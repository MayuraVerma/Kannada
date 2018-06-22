# FontLab Python module for Macros/System/Modules/
# Used by InstanceGenerator and KernFeatureGenerator

###################################################
### THE VALUES BELOW CAN BE EDITED AS NEEDED ######
###################################################

kKernFeatureFileName = "features.kern"
kDefaultMinKern = 3  #inclusive; this means that pairs which EQUAL this ABSOLUTE value will NOT be ignored/trimmed. Anything below WILL.
kDefaultWriteTrimmed = False  #if 'False', trimmed pairs will not be process and, therefore, will not be written to the 'features.kern' file.
					  #for a different default behavior change the value to 'True'.
kLeftTag = ['_LEFT','_1ST']
kRightTag = ['_RIGHT','_2ND']

kLatinTag = '_LAT'
kGreekTag = '_GRK'
kCyrillicTag = '_CYR'
kArabicTag = '_ARA'
kHebrewTag = '_HEB'

kNumberTag = '_NUM'
kFractionTag = '_FRAC'

kExceptionTag = 'EXC_'

kIgnorePairTag = '.cxt'
	
###################################################

__copyright__ =  """
Copyright (c) 2006, 2007, 2009, 2010 Adobe Systems Incorporated
Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
"""

__doc__ = """
WriteKernFeaturesFDK.py v2.3.2 - Jun 20 2011

Contains a class (kernDataClass) which, when provided with a FontLab font and a path to a folder, will output 
a file named "features.kern", containing a features-file syntax definition of the font's kerning.

This script allows the user to customize the minimum kerning value, i.e. the kerning threshold. If the "kDefaultMinKern"
value is set to 5 (five), kern pair values of -4, -3, -2, -1, 0, 1, 2, 3 and 4 will be ignored. To include the
ignored pairs in the 'features.kern' file, change the value of "kDefaultWriteTrimmed" to 'True'. Keep in mind that the
trimmed pairs will appear in the 'features.kern' file, but they won't be implemented in the font, because
the lines will be preceded by a number sign (#).

VERY IMPORTANT: For the creation of the 'features.kern' file to work well, the following class naming rules 
should be followed:

	Left side classes must contain the string "_LEFT"
	Right side classes must contain the string "_RIGHT"
	Classes to be used on both left and right sides of a kern pair must NOT contain "_LEFT" or "_RIGHT"
	
	Latin glyph classes should contain the string "_LAT"
	Greek glyph classes must contain the string "_GRK"
	Cyrillic glyph classes must contain the string "_CYR"
	
	Exception classes must start with the string "EXC_" and the key glyph of the class (marked by a single 
		quote [']) can NOT be the same as the key glyph of another kerning class.
	
	Examples of kerning classes (in FontLab syntax):
		_A_LC_RIGHT: a' a.end aacute acircumflex adieresis agrave ae
		_T_UC: T' Tcaron Tcommaaccent Tcedilla
		_K_UC_LEFT_LAT: K' K.alt Kcommaaccent
		_E_SC_LEFT_LAT: e.sc' E.sc aeacute.sc AEacute.sc ebreve.sc Ebreve.sc
		_GHE_UC_LEFT_CYR: Ghe' Ghe.up Gje
		_EPSILON_LC_GRK: epsilon' epsilonacute epsilonasper epsilonasperacute
		_EXC_E_LC_LEFT_LAT: edieresis' egrave ebreve ecaron emacron etilde

There is no absolute requirement to use any of the strings above, but their usage will facilitate the creation 
of a correct "features.kern" file, which will prevent kerning class overlapping and subtable overflow.

The default strings values (_LEFT, _LAT, etc.) can be replaced for other values as needed, by editing the 
entries located at the top of this file.

If a script tag (_LAT, _GRK or _CYR) is used in one kerning class, all kerning classes related with 
that script MUST use the tag string as well.

Classes that do not contain a side tag (_LEFT or _RIGHT), will be used on both sides of a kerning pair. Classes
containing only symmetrical glyphs, normally do not require a side tag. Nonetheless, adding side tags is a good 
practice, as it can prevent overlap of classes.

It is possible to do multiple kerning exceptions at once, by grouping all the exception glyphs in the same 
class, and making a kerning exception with the key glyph of the class. However, the key glyph of an exception
class can NOT be the key glyph of another class at the same time.

In order to process all RTL kerning pairs as such, all the RTL glyphs need to be included in kerning classes 
tagged as RTL (via the usage of _ARA or _HEB in the classes' names). A RTL kerning class needs to be created
even if its content is one single glyph.

==================================================

Versions:
v1.0 - Apr 24 2007 - Initial release
v1.1 - Dec 03 2007 - Robofab dependency removed (code changes suggested by Karsten Luecke)
v2.0 - Feb 15 2010 - Rewrite to make the module self contained and tiddy. Fixed a bug that prevented representative glyphs to be found.
v2.1 - Feb 19 2010 - Added checks to verify the existence of kern pairs and kern classes
v2.2 - Jun 10 2010 - Enabled multiple names for tagging the side of kerning classes. Added support for RTL kerning.
v2.3 - Jan 17 2011 - Revised the support for RTL kerning. Added documentation regarding the setup requirements for RTL kerning.
v2.3.1 - Fev 12 2011 - Fixed a bug related with the handling of RTL kerning class pairs: pairs where only the right class was RTL were being sorted incorrectly.
v2.3.2 - Jun 20 2011 - Added an option to ignore some pairs, based on the name of the left glyph

"""

import os, time

class kernDataClass:
	def __init__(self, font, folderPath, minKern=kDefaultMinKern, writeTrimmed=kDefaultWriteTrimmed):
		self.f = font
		self.folder = folderPath
		self.minKern = minKern
		self.writeTrimmed = writeTrimmed
		self.instanceFontInfo = "# Created: %s\n# PS Name: %s\n# MM Inst: %s\n# MinKern: +/- %d inclusive\n\n" % (time.ctime(), self.f.font_name, self.f.menu_name, self.minKern)
		self.kernClassesNamesList = [] # ["_A_LC", "_T_UC_RIGHT", "_K_UC_LEFT"]
		self.kernDict = {} # will be a dictionary of tuples of the kerning pairs and their values; {('quoteleft', 'p'): -15, ('Y', 'edieresis'): -95, ('sigma', 'theta'): 15, ('E', 'a.sc'): 30}
		self.kernClassesDict = {} # {'_A_LC': ["a'", 'aacute', 'agrave'], '_T_UC_RIGHT': ["T'", 'T_h', 'Tcaron'], '_K_UC_LEFT': ["K'", 'K.alt']}
		self.OTkernClasses = []
		self.bothClassesList = []
		self.leftReps = {}
		self.rightReps = {}

		self.kernPairsGG = []
		self.kernPairsCC = []
		self.kernPairsEx1 = []
		self.kernPairsEx2 = []

		self.RTLkernPairsGG = []
		self.RTLkernPairsEx1 = []
		self.RTLkernPairsEx2 = []

		self.notProcessed = 0
		
		self.excptPairs = []
		self.latinPairs = []
		self.greekPairs = []
		self.cyrilPairs = []
		self.arabiPairs = []
		self.hebrePairs = []
		self.numbrPairs = []
		self.otherPairs = []
		
		self.numBreaks = 0
		self.subtbBreak = '\nsubtable;\n\n'
		self.lineBreak = '\n'
		self.lkupRTLopen = '\nlookup RTL_kerning {\nlookupflag RightToLeft IgnoreMarks;\n'
		self.lkupRTLclose = '} RTL_kerning;\n'
	
		self.readFontKerning()
		if not len(self.kernDict):
			print "ERROR: The font has no kerning!"
			return

		self.readFontKernClasses()
		if not len(self.kernClassesNamesList):
			print "WARNING: The font has no kerning classes!"
		else:
			self.buildOTclasses()
			bothTagsList = kLeftTag + kRightTag
			self.getBothClasses(bothTagsList)
			
			#Makes lists of left and right kerning classes and adds classes that belong to both sides
			self.leftClasses = self.separateClasses(kLeftTag) + self.bothClassesList
			self.rightClasses = self.separateClasses(kRightTag) + self.bothClassesList
			
			#Makes dictionaries of left and right reps with class names
			self.leftReps = self.getReps(self.leftClasses)
			self.rightReps = self.getReps(self.rightClasses)
		
		self.processKerningPairs()
		self.sortClassKerningPairs()
		self.sanityCheck()
		self.writeDataToFile()


	def readFontKerning(self):
		glyphs = self.f.glyphs
		for gIdx in range(len(glyphs)):
			gName = str(glyphs[gIdx].name)
			gKerning = glyphs[gIdx].kerning
			for gKern in gKerning:
				gNameRightglyph = str(glyphs[gKern.key].name)
				gKernValue = int(gKern.value)
				self.kernDict[(gName,gNameRightglyph)] = gKernValue
	

	def readFontKernClasses(self):
		classes = self.f.classes
		for c in classes:
			sep = c.find(":")
			if sep != -1:
				cName = str(c[:sep].strip())
				cGlyphs = c[sep+1:].strip().split()
				if (cName[0] == "_" and len(cGlyphs)):
					self.kernClassesNamesList.append(cName)
					self.kernClassesDict[cName] = cGlyphs


	def buildOTclasses(self):
		print '\tBuilding OT classes...'
		for kc in self.kernClassesNamesList:
			cName = kc[1:] # kerning class name without initial underscore (_)
			cGlyphsList = self.kernClassesDict.get(kc) # list of glyph names
			cGlyphs = ' '.join(cGlyphsList) # converts list to string (of space separated glyph names)
			cGlyphs = cGlyphs.replace("'","") # removes quote mark(s)
			line = '@%s = [%s];\n' % (cName, cGlyphs)
			self.OTkernClasses.append(line)


	def getBothClasses(self, bothTagsList): #Makes a list of kerning classes that are *both* LEFT and RIGHT (i.e. classes that do not contain LEFT or RIGHT (or 1ST or 2ND) in their name)
		for b in self.kernClassesNamesList:
			sideTagNotFound = True
			for tag in bothTagsList: # Cycle through the list of tags and break as soon as a match is found
				if tag in b:
					sideTagNotFound = False
					break
			if sideTagNotFound:
				self.bothClassesList.append(b)


	def separateClasses(self, sideTagsList): #Returns a list of kerning classes that are either LEFT or RIGHT (or 1ST or 2ND)
		cList = []
		for cl in self.kernClassesNamesList: # loops through kerning classes
			sideTagFound = False
			for sideTag in sideTagsList:
				if sideTag in cl: # Cycle through the list of tags and break as soon as a match is found
					sideTagFound = True
					break
			if sideTagFound:
				cList.append(cl)
		return cList


	def getReps(self, sepClasses): #Returns a dictionary in the form of {'repGlyph': '_className'}
		cReps = {}
		for cl in sepClasses:  #loops through list of classes
			repWasMarked = False
			gList = self.kernClassesDict.get(cl)  #gets a list of the glyphs contained in each class
			for g in gList:  #loops through list of glyphs
				if len(g) > 0:  #avoids list entries that are null
					if g[-1] == "'":  #selects representative glyph
						cReps[g] = cl  #adds an entry to the dictionary
						repWasMarked = True
						break
			if not repWasMarked: # in case the representative glyph is not marked with the single quote,
				repG = gList[0] + "'"
				cReps[repG] = cl # assume that the rep glyph is the first one in the class.
				print "WARNING: Kerning class %s has no explicit representative glyph." % cl
		return cReps


	def replaceByClass(self, g, sideReps): #Returns the class name (without the trailing underscore), replacing the representative glyph by its class name
		className = sideReps[g]
		return '%s' % className[1:]


	def processKerningPairs(self):
		print '\tProcessing kerning pairs...'
		
		kernPairsTup = self.kernDict.keys() # List of tuples of the kerning pairs [('quoteleft', 'p'), ('Y', 'edieresis'), ('sigma', 'theta'), ('E', 'a.sc')]
		kernPairsTup.sort()
		
		RTLkerningTagsList = [kArabicTag , kHebrewTag]
		
		for pair in kernPairsTup:
			kernValue = self.kernDict[pair]
			if abs(kernValue) >= self.minKern or self.writeTrimmed:  #The pairs are only processed if the value is above the minimum OR if writeTrimmed is 'True'
				Left = pair[0]
				Right = pair[1]
				RepLeft = pair[0]+"'"
				RepRight = pair[1]+"'"
				
				isRTLpair = False
				
				# skip the pairs where the name of the left glyph contains the ignore tag
				if kIgnorePairTag in Left:
					self.notProcessed += 1
					continue
				
				# check the minimum kerning value
				if abs(kernValue) < self.minKern:
					line = '#'
				else:
					line = ''
			
				# check if *both* LEFT and RIGHT glyphs of the pair can be replaced by classes
				if self.leftReps.has_key(RepLeft) and self.rightReps.has_key(RepRight):
					leftClass = self.replaceByClass(RepLeft, self.leftReps)
					rightClass = self.replaceByClass(RepRight, self.rightReps)
					
					for tag in RTLkerningTagsList:
						if (tag in leftClass) or (tag in rightClass):
							isRTLpair = True
							break
					
					#number of elements in class
					lenghtLeftClass = len(self.kernClassesDict.get('_'+ leftClass))
					lenghtRightClass = len(self.kernClassesDict.get('_'+ rightClass))
			
					#check if both classes have only one element
					if lenghtLeftClass == 1 and lenghtRightClass == 1:
						if isRTLpair:
							line += 'pos %s %s <%d 0 %d 0>;\n' % (Left, Right, kernValue, kernValue)
							self.RTLkernPairsGG.append(line)
						else:
							line += 'pos %s %s %d;\n' % (Left, Right, kernValue)
							self.kernPairsGG.append(line)
					
					else:
						Left = '@%s' % leftClass
						Right = '@%s' % rightClass
						if isRTLpair:
							line += 'pos %s %s <%d 0 %d 0>;\n' % (Left, Right, kernValue, kernValue)
						else:
							line += 'pos %s %s %d;\n' % (Left, Right, kernValue)
						self.kernPairsCC.append(line)
			
				# check if at least one of the glyphs in the pair can be replaced by a class
				elif self.leftReps.has_key(RepLeft) or self.rightReps.has_key(RepRight):
					
					# check if is the LEFT glyph in the pair
					if self.leftReps.has_key(RepLeft):
						leftClass = self.replaceByClass(RepLeft, self.leftReps)
						
						for tag in RTLkerningTagsList:
							if (tag in leftClass):
								isRTLpair = True
								break
						
						#if the class has only 1 element
						if len(self.kernClassesDict.get('_'+ leftClass)) == 1:
							if isRTLpair:
								line += 'pos %s %s <%d 0 %d 0>;\n' % (Left, Right, kernValue, kernValue)
								self.RTLkernPairsGG.append(line)
							else:
								line += 'pos %s %s %d;\n' % (Left, Right, kernValue)
								self.kernPairsGG.append(line)
						else:
							Left = '@%s' % leftClass
							if isRTLpair:
								line += 'enum pos %s [%s] <%d 0 %d 0>;\n' % (Left, Right, kernValue, kernValue)
								self.RTLkernPairsEx1.append(line)
							else:
								line += 'enum pos %s [%s] %d;\n' % (Left, Right, kernValue)
								self.kernPairsEx1.append(line)
					
					# check if is the RIGHT glyph in the pair
					elif self.rightReps.has_key(RepRight):
						rightClass = self.replaceByClass(RepRight, self.rightReps)
						
						for tag in RTLkerningTagsList:
							if (tag in rightClass):
								isRTLpair = True
								break
						
						#if the class has only 1 element
						if len(self.kernClassesDict.get('_'+ rightClass)) == 1:
							if isRTLpair:
								line += 'pos %s %s <%d 0 %d 0>;\n' % (Left, Right, kernValue, kernValue)
								self.RTLkernPairsGG.append(line)
							else:
								line += 'pos %s %s %d;\n' % (Left, Right, kernValue)
								self.kernPairsGG.append(line)
						else:
							Right = '@%s' % rightClass
							if isRTLpair:
								line += 'enum pos [%s] %s <%d 0 %d 0>;\n' % (Left, Right, kernValue, kernValue)
								self.RTLkernPairsEx2.append(line)
							else:
								line += 'enum pos [%s] %s %d;\n' % (Left, Right, kernValue)
								self.kernPairsEx2.append(line)
			
				else:
					line += 'pos %s %s %d;\n' % (Left, Right, kernValue)
					self.kernPairsGG.append(line)
			
			else:
				self.notProcessed += 1


	def checkLeftClass(self, tag, line): #Checks if a given tag is present in the name of the left class
		chuncks = [x.strip() for x in line.split()]  #transforms each line in a list of strings, dividing them by white space
		if tag in chuncks[1]:  # ['pos','@XXX']  or  ['#pos','@XXX']
			return True
		else:
			return False


	def checkRightClass(self, tag, line):
		chuncks = [x.strip() for x in line.split()]
		if tag in chuncks[2]:
			return True
		else:
			return False


	def sortClassKerningPairs(self):
# 		print '\tSorting class-kerning pairs...'
		
		for ln in self.kernPairsCC:
			if self.checkRightClass(kExceptionTag, ln):
				if '#pos' in ln:
					self.excptPairs.append('#enum ' + ln)
				else:
					self.excptPairs.append('enum ' + ln)
			elif self.checkLeftClass(kExceptionTag, ln):
				if '#pos' in ln:
					self.excptPairs.append('#enum ' + ln)
				else:
					self.excptPairs.append('enum ' + ln)
			elif self.checkLeftClass(kLatinTag, ln): self.latinPairs.append(ln)
			elif self.checkLeftClass(kGreekTag, ln): self.greekPairs.append(ln)
			elif self.checkLeftClass(kCyrillicTag, ln): self.cyrilPairs.append(ln)
			elif self.checkLeftClass(kArabicTag, ln) or self.checkRightClass(kArabicTag, ln): self.arabiPairs.append(ln)
			elif self.checkLeftClass(kHebrewTag, ln) or self.checkRightClass(kHebrewTag, ln): self.hebrePairs.append(ln)
			elif (self.checkLeftClass(kNumberTag, ln) or self.checkLeftClass(kFractionTag, ln)): self.numbrPairs.append(ln)
			else: self.otherPairs.append(ln)
		
		
		self.allKernPairs = self.excptPairs[:] # makes copy
		self.allKernPairs.append(self.lineBreak)
		self.numBreaks += 1
	
		self.allKernPairs.extend(self.kernPairsGG)
		self.allKernPairs.append(self.lineBreak)
		self.numBreaks += 1
	
		self.allKernPairs.extend(self.kernPairsEx1)
		self.allKernPairs.extend(self.kernPairsEx2)
		self.allKernPairs.append(self.lineBreak)
		self.numBreaks += 1
		
		if len(self.latinPairs):
			self.allKernPairs.extend(self.latinPairs)
			self.allKernPairs.append(self.subtbBreak)
			self.numBreaks += 1
	
		if len(self.greekPairs):
			self.allKernPairs.extend(self.greekPairs)
			self.allKernPairs.append(self.subtbBreak)
			self.numBreaks += 1
	
		if len(self.cyrilPairs):
			self.allKernPairs.extend(self.cyrilPairs)
			self.allKernPairs.append(self.subtbBreak)
			self.numBreaks += 1
	
		self.allKernPairs.extend(self.otherPairs)
	
		if len(self.numbrPairs):
			self.allKernPairs.append(self.subtbBreak) # subtable break before
			self.allKernPairs.extend(self.numbrPairs)
			self.numBreaks += 1
		
		# RTL kerning
		if len(self.RTLkernPairsGG) or len(self.RTLkernPairsEx1) or len(self.RTLkernPairsEx2) or len(self.arabiPairs) or len(self.hebrePairs):
			self.allKernPairs.append(self.lkupRTLopen) # lookupflag start
			self.allKernPairs.append(self.lineBreak)
			self.numBreaks += 1

			if len(self.RTLkernPairsGG):
				self.allKernPairs.extend(self.RTLkernPairsGG)
				self.allKernPairs.append(self.lineBreak)
				self.numBreaks += 1
	
			if len(self.RTLkernPairsEx1) or len(self.RTLkernPairsEx2):
				self.allKernPairs.extend(self.RTLkernPairsEx1)
				self.allKernPairs.extend(self.RTLkernPairsEx2)
				self.allKernPairs.append(self.lineBreak)
				self.numBreaks += 1
	
			if len(self.arabiPairs) or len(self.hebrePairs):
				self.allKernPairs.extend(self.arabiPairs)
				self.allKernPairs.extend(self.hebrePairs)
	
			self.allKernPairs.append(self.lkupRTLclose) # lookupflag end
			self.numBreaks += 2


	def sanityCheck(self):
		# Just double-checking...
		# check if the number of kerning pairs inputted
		# equals the number of kerning entries outputted
		if len(self.kernDict) != len(self.allKernPairs) + self.notProcessed - self.numBreaks:
			print 'Something went wrong...'
			print 'Kerning pairs provided: %d' % len(self.kernDict)
			print 'Kern entries generated: %d' % (len(self.allKernPairs) - self.numBreaks)
			print 'Pairs not processed: %d' % self.notProcessed
	

	def writeDataToFile(self):
		print '\tSaving %s file...' % kKernFeatureFileName
		filePath = os.path.join(self.folder, kKernFeatureFileName)
# 		if os.path.isfile(filePath):
# 			os.chmod(filePath, 0644)  # makes file writable, if it happens to be set to read-only
		outfile = open(filePath, 'w')
		outfile.write(self.instanceFontInfo)
		if len(self.OTkernClasses):
			outfile.writelines(self.OTkernClasses)
			outfile.write(self.lineBreak)
		if len(self.allKernPairs):
			outfile.writelines(self.allKernPairs)
			outfile.write(self.lineBreak)
		outfile.close()
