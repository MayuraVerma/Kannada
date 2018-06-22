"""
FDKUtils.py v 1.1 May 6 2006
 A module of functions that are needed by several of the FDK scripts.
"""

__copyright__ =  """
Copyright (c) 2006, 2008 Adobe Systems Incorporated

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

import os
import sys
import subprocess
import traceback

AdobeCMAPS = "Adobe Cmaps"
AdobeCharsets = "CID charsets"

class FDKEnvError(KeyError):
	pass

def findFDKDirs():
	fdkScriptsDir = None
	fdkToolsDir = None
	""" Look up the file path to find the "Tools" directory;
	then add the os.name for the executables, and .'FDKScripts' for the scripts.
	"""
	dir = os.path.dirname(__file__)

	while dir:
		if os.path.basename(dir) == "Tools":
			fdkScriptsDir = os.path.join(dir, "SharedData", "FDKScripts")
			if sys.platform == "darwin":
				fdkToolsDir = os.path.join(dir, "osx")
			elif os.name == "nt":
				fdkToolsDir = os.path.join(dir, "win")
			else:
				print "Fatal error: un-supported platform %s %s." % (os.name, sys.platform)
				raise FDKEnvError

			if not (os.path.exists(fdkScriptsDir) and os.path.exists(fdkToolsDir)):
				print "Fatal error: could not find  the FDK scripts dir %s and the tools directory %s." % (fdkScriptsDir, fdkToolsDir)
				raise FDKEnvError
 
			# the FDK.py bootstrap program already adds fdkScriptsDir to the  sys.path;
			# this is useful only when running the calling script directly using an external Python.
			if not fdkScriptsDir in sys.path:
				sys.path.append(fdkScriptsDir)
			fdkSharedDataDir = os.path.join(dir, "SharedData")
			break
		dir = os.path.dirname(dir)
	return fdkToolsDir,fdkSharedDataDir


def findFDKFile(fdkDir, fileName):
	path = os.path.join(fdkDir, fileName)
	if os.path.exists(path):
            return path
        p1 = path + ".exe"
 	if os.path.exists(p1):
            return p1
        p2 = path + ".cmd"
	if os.path.exists(p2):
            return p2
	if fileName not in ["addGlobalColor"]:
		print "Fatal error: could not find '%s or %s or %s'." % (path,p1,p2)
	raise FDKEnvError

def runShellCmd(cmd):
	try:
		p = subprocess.Popen(cmd, shell=True, stdout=subprocess.PIPE, stderr=subprocess.STDOUT).stdout
		log = p.read()
		return log
	except :
		msg = "Error executing command '%s'. %s" % (cmd, traceback.print_exc())
		print(msg)
		return ""

def runShellCmdLogging(cmd):
	try:
		retcode = subprocess.call(cmd, shell=True, stderr=subprocess.STDOUT)
		if retcode < 0:
			msg = "command was terminated by signal '%s'. '%s'" % (retcode, cmd)
			print(msg)
			return retcode
	except:
		msg = "Error executing command '%s'. %s" % (cmd, traceback.print_exc())
		print(msg)
		return 1
	return 0
