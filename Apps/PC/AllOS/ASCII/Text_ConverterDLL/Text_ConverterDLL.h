// Text_ConverterDLL.h : main header file for the TEXT_CONVERTERDLL DLL
//

#if !defined(AFX_TEXT_CONVERTERDLL_H__D585E930_65C5_42E4_AF90_597FABDB7B2F__INCLUDED_)
#define AFX_TEXT_CONVERTERDLL_H__D585E930_65C5_42E4_AF90_597FABDB7B2F__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#ifndef __AFXWIN_H__
	#error include 'stdafx.h' before including this file for PCH
#endif

#include "resource.h"		// main symbols

#define PRAKASHAK 1
#define SRG95 2
#define SRG98 3
#define SREELIPI 4
#define SURABHI 5
#define ANUFONTS 6
//#define SRG95 2

/////////////////////////////////////////////////////////////////////////////
// CText_ConverterDLLApp
// See Text_ConverterDLL.cpp for the implementation of this class
//

class CText_ConverterDLLApp : public CWinApp
{
public:
	CText_ConverterDLLApp();

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CText_ConverterDLLApp)
	//}}AFX_VIRTUAL

	//{{AFX_MSG(CText_ConverterDLLApp)
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

long __stdcall	   getRepString(char *pattern,LPSTR repVal,int FontFamily);

//RegQueryValueExA ( HKEY hKey, LPCSTR lpValueName, LPDWORD lpReserved,LPDWORD lpType,LPBYTE lpData,LPDWORD lpcbData);
/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_TEXT_CONVERTERDLL_H__D585E930_65C5_42E4_AF90_597FABDB7B2F__INCLUDED_)
