// stdafx.h : include file for standard system include files,
//  or project specific include files that are used frequently, but
//      are changed infrequently
//

#if !defined(AFX_STDAFX_H__05BCFD4A_B285_45D5_9B29_FD3332F16922__INCLUDED_)
#define AFX_STDAFX_H__05BCFD4A_B285_45D5_9B29_FD3332F16922__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#define VC_EXTRALEAN		// Exclude rarely-used stuff from Windows headers

#include <afxwin.h>         // MFC core and standard components
#include <afxext.h>         // MFC extensions

#ifndef _AFX_NO_OLE_SUPPORT
#include <afxole.h>         // MFC OLE classes
#include <afxodlgs.h>       // MFC OLE dialog classes
#include <afxdisp.h>        // MFC Automation classes
#endif // _AFX_NO_OLE_SUPPORT


#ifndef _AFX_NO_DB_SUPPORT
#include <afxdb.h>			// MFC ODBC database classes
#endif // _AFX_NO_DB_SUPPORT

#ifndef _AFX_NO_DAO_SUPPORT
#include <afxdao.h>			// MFC DAO database classes
#endif // _AFX_NO_DAO_SUPPORT

#include <afxdtctl.h>		// MFC support for Internet Explorer 4 Common Controls
#ifndef _AFX_NO_AFXCMN_SUPPORT
#include <afxcmn.h>			// MFC support for Windows Common Controls
#endif // _AFX_NO_AFXCMN_SUPPORT


#define EXPORTED_DLL_FUNCTION \
	__declspec(dllexport)__stdcall

INT EXPORTED_DLL_FUNCTION	 PrakToKuvempu(char* pattern);
INT EXPORTED_DLL_FUNCTION    Srg95ToKuvempu(char* pattern);
INT EXPORTED_DLL_FUNCTION    Srg95ToKuvempu(char* pattern);
INT EXPORTED_DLL_FUNCTION    SreeLipiToKuvempu(char* pattern);
INT EXPORTED_DLL_FUNCTION    SurabhiToKuvempu(char* pattern);
INT EXPORTED_DLL_FUNCTION	 AnuToKuvempu(char* pattern);

INT EXPORTED_DLL_FUNCTION    compstr(char buffer[65535],int k);
INT EXPORTED_DLL_FUNCTION    compsubstr(char var[11],char buffer[65535],int len,int k);


//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_STDAFX_H__05BCFD4A_B285_45D5_9B29_FD3332F16922__INCLUDED_)