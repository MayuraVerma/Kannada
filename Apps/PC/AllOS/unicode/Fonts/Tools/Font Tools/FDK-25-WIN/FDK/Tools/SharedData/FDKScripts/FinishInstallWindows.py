##***********************************************************************#
#*                                                                     *#
#* Copyright 2008, 2009 Adobe Systems Incorporated.                          *#
#* All rights reserved.                                                *#
#*                                                                     *#
#* Patents Pending                                                     *#
#*                                                                     *#
#* NOTICE: All information contained herein is the property of Adobe   *#
#* Systems Incorporated. Many of the intellectual and technical        *#
#* concepts contained herein are proprietary to Adobe, are protected   *#
#* as trade secrets, and are made available only to Adobe licensees    *#
#* for their internal use. Any reproduction or dissemination of this   *#
#* software is strictly forbidden unless prior written permission is   *#
#* obtained from Adobe.                                                *#
#*                                                                     *#
#* PostScript and Display PostScript are trademarks of Adobe Systems   *#
#* Incorporated or its subsidiaries and may be registered in certain   *#
#* jurisdictions.                                                      *#
#*                                                                     *#
#***********************************************************************#
"""
FinishInstallWindows.py v1.2 Jan 7 2009
"""

import sys
import os

import _winreg

def isNotFDKDir(dirPath):
	if not os.path.isdir(dirPath):
		if "FDK" in dirPath:
			print "Note: Removing old FDK path '%s' from PATH list." % (dirPath)
			return 0 # I suspect this of being an old FDK path. Can't hurt to delete it if it doesn't exist.
		else:
			return 1
	if not "win" in dirPath:
			return 1
	testPath = os.path.join(dirPath, "tx.exe")
	if os.path.exists(testPath):
		print "Note: removing old FDK path '%s' from PATH list." % (dirPath)
		return 0
	return 1
	
def removeOldFDKDirectories(path):
	dirList = path.split(";")
	dirList = filter(isNotFDKDir, dirList)
	path = ";".join(dirList)
	return path
	
def getRegistryValue(registry, key, name):
	kHandle = _winreg.OpenKey(registry, key)
	value = _winreg.QueryValueEx(kHandle, name)[0]
	_winreg.CloseKey(kHandle)
	return value

def setRegistryValue(registry, key, name, value, valueType=_winreg.REG_SZ):
	kHandle = _winreg.OpenKey(registry, key, 0, _winreg.KEY_WRITE)
	_winreg.SetValueEx(kHandle, name, 0, valueType, value)
	_winreg.CloseKey(kHandle)



def main():
	try:
		fdkPath = os.environ["AFDKO_EXE_PATH"]
		fdkPath = fdkPath.strip("\"")
		if fdkPath.endswith("\\"):
			fdkPath = fdkPath[:-1]
	except KeyError:
		print "Quitting. Failed to determine the FDK path."
		print "Please report this to Adobe."
		return

	try:
		registry = _winreg.ConnectRegistry(None, _winreg.HKEY_LOCAL_MACHINE)
		key = r"SYSTEM\CurrentControlSet\Control\Session Manager\Environment"
		path = getRegistryValue(registry, key, "Path")
		path = removeOldFDKDirectories(path)
		path += ";" + fdkPath
		print "Adding the FDK executable path '%s' to the system environment variable PATH." % (fdkPath)
		setRegistryValue(registry, key, "Path", path, _winreg.REG_EXPAND_SZ)
		print "Success."
		print "You now need to log off or restart; the FDK commands will then work in a new command window."
	except:
		print "Error", repr(sys.exc_info()[1])
		if "Access" in repr(sys.exc_info()[1]):
			print "You need system admin privileges to run this script and install the FDK."
		else:
			print "You will have to manually add the path to the FDK root directory to the system environment variable PATH in order to make the FDK work."
		print "Quitting. Failed to add the FDK path to the system environment variable PATH."
	return
	



if __name__=='__main__':
	main()
