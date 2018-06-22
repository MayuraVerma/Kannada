// Text_ConverterDLL.cpp : Defines the initialization routines for the DLL.
//

#include "stdafx.h"
#include "Text_ConverterDLL.h"
#include "KeyMaps.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

//
//	Note!
//
//		If this DLL is dynamically linked against the MFC
//		DLLs, any functions exported from this DLL which
//		call into MFC must have the AFX_MANAGE_STATE macro
//		added at the very beginning of the function.
//
//		For example:
//
//		extern "C" BOOL PASCAL EXPORT ExportedFunction()
//		{
//			AFX_MANAGE_STATE(AfxGetStaticModuleState());
//			// normal function body here
//		}
//
//		It is very important that this macro appear in each
//		function, prior to any calls into MFC.  This means that
//		it must appear as the first statement within the 
//		function, even before any object variable declarations
//		as their constructors may generate calls into the MFC
//		DLL.
//
//		Please see MFC Technical Notes 33 and 58 for additional
//		details.
//

/////////////////////////////////////////////////////////////////////////////
// CText_ConverterDLLApp

BEGIN_MESSAGE_MAP(CText_ConverterDLLApp, CWinApp)
	//{{AFX_MSG_MAP(CText_ConverterDLLApp)
		// NOTE - the ClassWizard will add and remove mapping macros here.
		//    DO NOT EDIT what you see in these blocks of generated code!
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CText_ConverterDLLApp construction

CText_ConverterDLLApp::CText_ConverterDLLApp()
{
	// TODO: add construction code here,
	// Place all significant initialization in InitInstance
}

/////////////////////////////////////////////////////////////////////////////
// The one and only CText_ConverterDLLApp object

CText_ConverterDLLApp theApp;



// ConverterTest.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"

#include <stdio.h>
#include <string.h>


//int open_file(const char *name);
static char substituteChars[1024] = { '\0' };
static int repStrCounter = 0;

INT EXPORTED_DLL_FUNCTION compsubstr(char var[11],char buffer[65535],int len,int k)
{
    int i;
     for (i=0;i<len;i++)
     {
                    if(var[i]!=buffer[k+i])
                    return 0;
     }
     return 1;
}

INT EXPORTED_DLL_FUNCTION compstr(char buffer[65535],int k)
{
    int i;
    for (i= 0;i<NOOFCHARS_PRAK;i++)
    { 
        int j = 0;
        j = compsubstr(str[i].cvar1,buffer,strlen(str[i].cvar1),k);
        if(j == 1)
        {
			strncat(substituteChars,str[i].cvar2,strlen(str[i].cvar2));
			return strlen(str[i].cvar1);
        }
    }
    return 0;
}

INT EXPORTED_DLL_FUNCTION  PrakToKuvempu(char* pattern)
{
    int i,j,k;

       i = 0;

			k = 0; // INDEX FOR BUFFER TRAVERSING 
 //#if 1
			while(k <= (int)strlen(pattern)-1)
			{
                  j= 0;
                  j = compstr(pattern,k);
                  if(j>0)
                   {    
                        k = k+j; //change the k to point to current buffer 
                   }
                   else
                   {
					   substituteChars[strlen(substituteChars)] = pattern[k];
                       k++;
                   }
            }
//#endif
	return 1;
}


INT EXPORTED_DLL_FUNCTION  Srg95ToKuvempu(char* pattern)
{
			int j,bRet = FALSE;
			long int i;
		    
			static int found = 0;
			
			int flag = 1;
			int Made_Of_More_Chars = FALSE; // is set if character is made of 2 or more charcters
			
			long int k = 0;	// for buffer 
			
			int m = 0;  //Index for Progress Bar
			int l = 0;

			i = 0;

			k = 0; // INDEX FOR BUFFER TRAVERSING 
			
			while(k < (int)strlen(pattern))
			{
				found = 0;
				Made_Of_More_Chars = FALSE;

							//–	A	 G	H 
							if( (char)pattern[k] == '–' && ( (char)pattern[k+1] == 'A' || 
															(char)pattern[k+1] == 'G' || 
															(char)pattern[k+1] == 'H'
														  )
							  ) 
							{
								found = 1 ;
								strncat(substituteChars,"S",1);
								Made_Of_More_Chars = TRUE;
								k = k+1;
							}else
							//–	V
							if( (char)pattern[k] == '–' && (char)pattern[k+1] == 'V'  
							  ) 
							{
								found = 1 ;
								strncat(substituteChars,"SÈ",2);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}else
							//¢	A	 G	H		¢	V
							if( (char)pattern[k] == '¢' && ( (char)pattern[k+1] == 'A' || 
															(char)pattern[k+1] == 'G' || 
															(char)pattern[k+1] == 'H'
														  )
							  ) 
							{
								found = 1 ;
								strncat(substituteChars,"e",1);
								Made_Of_More_Chars = TRUE;
								k = k+1;
							}else
							//V
							if( (char)pattern[k] == '¢' && (char)pattern[k+1] == 'V'  
							  ) 
							{
								found = 1 ;
								strncat(substituteChars,"eÈ",2);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}else
							//¾	A	 G	H		¾	V
							if( (char)pattern[k] == '¾' && ( (char)pattern[k+1] == 'A' || 
															(char)pattern[k+1] == 'G' || 
															(char)pattern[k+1] == 'H'
														  )
							  ) 
							{
								found = 1 ;
								strncat(substituteChars,"¨",1);
								Made_Of_More_Chars = TRUE;
								k = k+1;
							}else
							//V
							if( (char)pattern[k] == '¾' && (char)pattern[k+1] == 'V'  
							  ) 
							{
								found = 1 ;
								strncat(substituteChars,"¨È",1);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}else
							//Æ	A	 G	H		Æ	V
							if( (char)pattern[k] == 'Æ' && ( (char)pattern[k+1] == 'A' || 
															(char)pattern[k+1] == 'G' || 
															(char)pattern[k+1] == 'H'
														  )
							  ) 
							{
								found = 1 ;
								strncat(substituteChars,"¯",1);
								Made_Of_More_Chars = TRUE;
								k = k+1;
							}else
							//V
							if( (char)pattern[k] == 'Æ' && (char)pattern[k+1] == 'V' 
							  ) 
							{
								found = 1 ;
								strncat(substituteChars,"¯È",1);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}else
							//Ù	A	 G	H		Ù	V
							if( (char)pattern[k] == 'Ù' && ( (char)pattern[k+1] == 'A' || 
															(char)pattern[k+1] == 'G' || 
															(char)pattern[k+1] == 'H'
														  )
							  ) 
							{
								found = 1 ;
								strncat(substituteChars,"eÕ",1);
								Made_Of_More_Chars = TRUE;
								k = k+1;
							}else
							//V
							if( (char)pattern[k] == 'Ù' && (char)pattern[k+1] == 'V'  
							  ) 
							{
								found = 1 ;
								strncat(substituteChars,"eÕÈ",3);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}else
							//w	A	 G	H		í	V
							if( (char)pattern[k] == 'w' && ( (char)pattern[k+1] == 'A' || 
															(char)pattern[k+1] == 'G' || 
															(char)pattern[k+1] == 'H'
														  )
							  ) 
							{
								found = 1 ;
								strncat(substituteChars,"Pë",2);
								Made_Of_More_Chars = TRUE;
								k = k+1;
							}else
							//V
							if( (char)pattern[k] == 'w' && (char)pattern[k+1] == 'V'  
							  ) 
							{
								found = 1 ;
								strncat(substituteChars,"PëÈ",3);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}else
							//Â		A	 G	H		í	V
							if( (char)pattern[k] == 'Â' && ( (char)pattern[k+1] == 'A' )
							  ) 
							{
								found = 1 ;
								strncat(substituteChars,"AiÀi",4);  //Á
								Made_Of_More_Chars = TRUE;
								k = k+1;
							}else
							//ëA
							if( (char)pattern[k] == 'ë' && (char)pattern[k+1] == 'A' 
							  ) 
							{
								found = 1 ;
								strncat(substituteChars,"gÀhiÁ",5);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}else
							//ÀA
							if( (char)pattern[k] == 'À' && (char)pattern[k+1] == 'A'  
							  ) 
							{
								found = 1 ;
								strncat(substituteChars,"ªÀiÁ",4);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}else
							//ÁA 
							if( (char)pattern[k] == 'Á' && (char)pattern[k+1] == 'A' 
														  ) 
							{
								found = 1 ;
								strncat(substituteChars,"«iÁ",3);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}else
							//[ 
							if( (char)pattern[k] == '[') 
							{
								found = 1 ;
								strncat(substituteChars,"Ûç",2);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}else
							// ËRD  ËRD
							if( (char)pattern[k] == 'Ë' &&  (char)pattern[k+1] == 'R' && (char)pattern[k+2] == 'D' ) 
							{
								found = 1 ;
								strncat(substituteChars,"±ÀÄæ",4);
								Made_Of_More_Chars = TRUE;
								k = k+3;
							}else
							//<<
							if( (char)pattern[k] == '<' &&  (char)pattern[k+1] == '<') 
							{
								found = 1 ;
								strncat(substituteChars,"“",1);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}else//>>
							if( (char)pattern[k] == '>' &&  (char)pattern[k+1] == '>') 
							{
								found = 1 ;
								strncat(substituteChars,"”",1);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}
							else///////////////////////////if not in above case ie; if character is not made of 2 characters
							{	
							
								for(i=0;i<NOOFCHARS_SRG95;i++)
								{
										
									if((char)Srg[i].vSrg == (char)pattern[k]) 
										{  
											found = 1 ;
											j=0;
											flag = 0;
											
											while(Srg[i].vKump[j] != -1)
											{
												substituteChars[strlen(substituteChars)] = (char)Srg[i].vKump[j];
												j++;
											}
										}
								}
							}
			
				if(!found)
				{
				//	strncat(substituteChars,(const char *)pattern[k],1); //If not in Table
					substituteChars[strlen(substituteChars)] = (char)pattern[k];
				}

				if(Made_Of_More_Chars != TRUE)
				{
					k++;//Set to next element in buffer
				}
			 }
	
		bRet = TRUE;
		
	return bRet;
}


INT EXPORTED_DLL_FUNCTION  Srg98ToKuvempu(const char* pattern)
{
			int j,bRet = FALSE;
			long int i;
		    
			static int found = 0;
			
			int flag = 1;
			int Made_Of_More_Chars = FALSE; // is set if character is made of 2 or more charcters
			
			long int k = 0;	// for pattern 
			
			i = 0;

			k = 0; // INDEX FOR pattern TRAVERSING 
			while(k < (int)strlen(pattern))
			{
				found = 0;
				Made_Of_More_Chars = FALSE;

							//–	A	 G	H 
							if( (char)pattern[k] == '–' && ( (char)pattern[k+1] == 'A' || 
															(char)pattern[k+1] == 'G' || 
															(char)pattern[k+1] == 'H'
														  )
							  ) 
							{
								found = 1 ;
								strncat(substituteChars,"S",1);
								Made_Of_More_Chars = TRUE;
								k = k+1;
							}else
							//–	V
							if( (char)pattern[k] == '–' && (char)pattern[k+1] == 'V'  
							  ) 
							{
								found = 1 ;
								strncat(substituteChars,"SÈ",2);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}else
							//¢	A	 G	H		¢	V
							if( (char)pattern[k] == '¢' && ( (char)pattern[k+1] == 'A' || 
															(char)pattern[k+1] == 'G' || 
															(char)pattern[k+1] == 'H'
														  )
							  ) 
							{
								found = 1 ;
								strncat(substituteChars,"e",1);
								Made_Of_More_Chars = TRUE;
								k = k+1;
							}else
							//V
							if( (char)pattern[k] == '¢' && (char)pattern[k+1] == 'V'  
							  ) 
							{
								found = 1 ;
								strncat(substituteChars,"eÈ",2);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}else
							//¾	A	 G	H		¾	V
							if( (char)pattern[k] == '¾' && ( (char)pattern[k+1] == 'A' || 
															(char)pattern[k+1] == 'G' || 
															(char)pattern[k+1] == 'H'
														  )
							  ) 
							{
								found = 1 ;
								strncat(substituteChars,"¨",1);
								Made_Of_More_Chars = TRUE;
								k = k+1;
							}else
							//V
							if( (char)pattern[k] == '¾' && (char)pattern[k+1] == 'V'  
							  ) 
							{
								found = 1 ;
								strncat(substituteChars,"¨È",1);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}else
							//Æ	A	 G	H		Æ	V
							if( (char)pattern[k] == 'Æ' && ( (char)pattern[k+1] == 'A' || 
															(char)pattern[k+1] == 'G' || 
															(char)pattern[k+1] == 'H'
														  )
							  ) 
							{
								found = 1 ;
								strncat(substituteChars,"¯",1);
								Made_Of_More_Chars = TRUE;
								k = k+1;
							}else
							//V
							if( (char)pattern[k] == 'Æ' && (char)pattern[k+1] == 'V' 
							  ) 
							{
								found = 1 ;
								strncat(substituteChars,"¯È",2);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}else
							//Ù	A	 G	H		Ù	V
							if( (char)pattern[k] == 'Ù' && ( (char)pattern[k+1] == 'A' || 
															(char)pattern[k+1] == 'G' || 
															(char)pattern[k+1] == 'H'
														  )
							  ) 
							{
								found = 1 ;
								strncat(substituteChars,"eÕ",2);
								Made_Of_More_Chars = TRUE;
								k = k+1;
							}else
							//V
							if( (char)pattern[k] == 'Ù' && (char)pattern[k+1] == 'V'  
							  ) 
							{
								found = 1 ;
								strncat(substituteChars,"eÕÈ",3);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}else
							//w	A	 G	H		í	V
							if( (char)pattern[k] == 'w' && ( (char)pattern[k+1] == 'A' || 
															(char)pattern[k+1] == 'G' || 
															(char)pattern[k+1] == 'H'
														  )
							  ) 
							{
								found = 1 ;
								strncat(substituteChars,"Pë",2);
								Made_Of_More_Chars = TRUE;
								k = k+1;
							}else
							//V
							if( (char)pattern[k] == 'w' && (char)pattern[k+1] == 'V'  
							  ) 
							{
								found = 1 ;
								strncat(substituteChars,"PëÈ",2);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}else
							//Â		A	 G	H		í	V
							if( (char)pattern[k] == 'Â' && ( (char)pattern[k+1] == 'A' )
							  ) 
							{
								found = 1 ;
								strncat(substituteChars,"AiÀi",4);  //Á
								Made_Of_More_Chars = TRUE;
								k = k+1;
							}else
							//ëA
							if( (char)pattern[k] == 'ë' && (char)pattern[k+1] == 'A' 
							  ) 
							{
								found = 1 ;
								strncat(substituteChars,"gÀhiÁ",5);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}else
							//ÀA
							if( (char)pattern[k] == 'À' && (char)pattern[k+1] == 'A'  
							  ) 
							{
								found = 1 ;
								strncat(substituteChars,"ªÀiÁ",4);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}else
							//ÁA 
							if( (char)pattern[k] == 'Á' && (char)pattern[k+1] == 'A' 
														  ) 
							{
								found = 1 ;
								strncat(substituteChars,"«iÁ",3);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}else
							//[ 
							if( (char)pattern[k] == '[') 
							{
								found = 1 ;
								strncat(substituteChars,"Ûç",2);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}else
							// ËRD  ËRD
							if( (char)pattern[k] == 'Ë' &&  (char)pattern[k+1] == 'R' && (char)pattern[k+2] == 'D' ) 
							{
								found = 1 ;
								strncat(substituteChars,"±ÀÄæ",4);
								Made_Of_More_Chars = TRUE;
								k = k+3;
							}else
							//<<
							if( (char)pattern[k] == '<' &&  (char)pattern[k+1] == '<') 
							{
								found = 1 ;
								strncat(substituteChars,"“",1);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}else//>>
							if( (char)pattern[k] == '>' &&  (char)pattern[k+1] == '>') 
							{
								found = 1 ;
								strncat(substituteChars,"”",1);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}else///////////////////////////if not in above case ie; if character is not made of 2 characters
							{	
							
								for(i=0;i<NOOFCHARS_SRG98;i++)
								{
										
									if((char)Srg2[i].vSrg == (char)pattern[k]) 
										{  
											found = 1 ;
											j=0;
											flag = 0;
											
											while(Srg2[i].vKump[j] != -1)
											{
												substituteChars[strlen(substituteChars)] = (char)Srg2[i].vKump[j];
												j++;
											}
										}
								}
							}
			
				if(!found)
				{
					//strncat(substituteChars,(const char *)pattern[k],1); //If not in Table
					substituteChars[strlen(substituteChars)] = (char)pattern[k];
				}

				if(Made_Of_More_Chars != TRUE)
				{
					k++;//Set to next element in buffer
				}
			 }
	
		bRet = TRUE;
		
	return bRet;
}


INT EXPORTED_DLL_FUNCTION  SreeLipiToKuvempu(char* pattern)
{
			int bRet=FALSE,j = 0;
			long int i;
		    
			static int found = 0;
			
			int flag = 1;
			int Made_Of_More_Chars = FALSE; // is set if character is made of 2 or more charcters
			
			int k = 0;	// for pattern 
			
			int m = 0;  //Index for Progress Bar
			int l = 0;
			//long int x = sizeof(long int)-2;
		
			i = 0;

			k = 0; // INDEX FOR pattern TRAVERSING 
			while(k < (int)strlen(pattern))
			{
				found = 0;
				Made_Of_More_Chars = FALSE;



							if((char)pattern[k] == 'S' && (char)pattern[k+1] == '|')
							{
								found = 1 ;
								strncat(substituteChars,"y",1);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}
							else
							if((char)pattern[k] == 'S' && (char)pattern[k+1] == '¬')
							{
								found = 1 ;
								strncat(substituteChars,"x",1);
								Made_Of_More_Chars = TRUE;
								k = k+2;
								//::MessageBox(NULL,"fdvfdv","fdvdvf",MB_OK);
							}
							else
							if((char)pattern[k] == '×' && (char)pattern[k+1] == '¬')
							{
								found = 1 ;
								strncat(substituteChars,"zs",2);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}
							else
							if((char)pattern[k] == '×' && (char)pattern[k+1] == '|')
							{
								found = 1 ;
								strncat(substituteChars,"¢ü",2);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							//	::MessageBox(NULL,"fdvfdv","fdvdvf",MB_OK);
							}
							else
							if((char)pattern[k] == 'Ü' && (char)pattern[k+1] == '¦')
							{
								found = 1 ;
								strncat(substituteChars,"rü",2);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}
							else
							if((char)pattern[k] == 'Ü' && (char)pattern[k+1] == 'û')
							{
								found = 1 ;
								strncat(substituteChars,"qs",2);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}
							else
							if((char)pattern[k] == '´' && (char)pattern[k+1] == 'î')
							{
								found = 1 ;
								strncat(substituteChars,"¨s",2);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}
							else
							if((char)pattern[k] == '´' && (char)pattern[k+1] == '[')
							{
								found = 1 ;
								strncat(substituteChars,"©ü",2);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}
							else
							if((char)pattern[k] == 'i' && (char)pattern[k+1] == 'F')
							{
								found = 1 ;
								strncat(substituteChars,"¥s",2);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}
							else
							if((char)pattern[k] == 'i' && (char)pattern[k+1] == '¡')
							{
								found = 1 ;
								strncat(substituteChars,"¦ü",2);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}
							else
							if((char)pattern[k] == 'ï' && (char)pattern[k+1] == '~')
							{
								found = 1 ;
								strncat(substituteChars,"o",1);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}
							else
							if((char)pattern[k] == 'ï' && (char)pattern[k+1] == 'Ô')
							{
								found = 1 ;
								strncat(substituteChars,"p",1);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}
							else
							if((char)pattern[k] == 'Æ' && (char)pattern[k+1] == 'F')
							{
								found = 1 ;
								strncat(substituteChars,"µ",1);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}
							else
							if((char)pattern[k] == 'Æ' && (char)pattern[k+1] == '¡')
							{
								found = 1 ;
								strncat(substituteChars,"¶",1);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}
							else
							if((char)pattern[k] == 'F' && (char)pattern[k+1] == '«' && (char)pattern[k+2] == 'Ù')
							{
								found = 1 ;
								strncat(substituteChars,"¥sÀÅ",4);
								Made_Of_More_Chars = TRUE;
								k = k+3;
							}
							else
							if((char)pattern[k] == 'F' && (char)pattern[k+1] == 'ã' && (char)pattern[k+2] == 'Ù')
							{
								found = 1 ;
								strncat(substituteChars,"¥sÉÅ",4);
								Made_Of_More_Chars = TRUE;
								k = k+3;
							}
							else
							if((char)pattern[k] == 'F' && (char)pattern[k+1] == '«'&& (char)pattern[k+2] == '¹')
							{
								found = 1 ;
								strncat(substituteChars,"¥sÀÇ",4);
								Made_Of_More_Chars = TRUE;
								k = k+3;
							}
							else
							if((char)pattern[k] == 'F' && (char)pattern[k+1] == 'ã'&& (char)pattern[k+2] == '¹')
							{
								found = 1 ;
								strncat(substituteChars,"¥sÁÇ",4);
								Made_Of_More_Chars = TRUE;
								k = k+3;
							}
							else///////////////////////////if not in above case ie; if character is not made of 2 characters
				for(i=0;i<NOCHARS_SREELIPI;i++)
				{
					if( (char)Sree[i].vSrg == (char)pattern[k] ) 
						{  
					//	::MessageBox(NULL,"vfdv","dfvfd",MB_OK);
							found = 1 ;
							j=0;
							flag = 0;
							
							while(Sree[i].vKump[j] != -1)
							{	
								//strncat(substituteChars,Sree[i].vKump[j]);
								substituteChars[strlen(substituteChars)] = (char)Sree[i].vKump[j];
								j++;
							}
						}
				}
			
				if(!found)
				{
				//	strncat(substituteChars,(const char *)pattern[k],1); //If not in Table
					substituteChars[strlen(substituteChars)] = (char)pattern[k];
				}

				if(Made_Of_More_Chars != TRUE)
				k++;//Set to next element in pattern
			 }
	
		bRet = TRUE;

		return bRet;
}


INT EXPORTED_DLL_FUNCTION  SurabhiToKuvempu(char* pattern)
{
	int bRet = FALSE , j = 0;
			long int i;
		    
			static int found = 0;
			
			int flag = 1;
			int Made_Of_More_Chars = FALSE; // is set if character is made of 2 or more charcters
			
			int k = 0;	// for pattern 
			
			int m = 0;  //Index for Progress Bar
			int l = 0;
			//long int x = sizeof(long int)-2;

			i = 0;

			k = 0; // INDEX FOR pattern TRAVERSING 
			while(k < (int) strlen(pattern))
			{
				found = 0;
				Made_Of_More_Chars = FALSE;


							if((char)pattern[k] == '¤' && (char)pattern[k+1] == 'ì')
							{
								strncat(substituteChars,"qs",2);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}
							else
							if((char)pattern[k] == '¥' && (char)pattern[k+1] == 'ì')
							{
								strncat(substituteChars,"rü",2);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							//	::MessageBox(NULL,"fdvfdv","fdvdvf",MB_OK);
							}
							else
							if((char)pattern[k] == '¹' && (char)pattern[k+1] == 'ì')
							{
								strncat(substituteChars,"zs",2);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}
							else
							if((char)pattern[k] == 'º' && (char)pattern[k+1] == 'ì')
							{
								strncat(substituteChars,"¢ü",2);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							//	::MessageBox(NULL,"fdvfdv","fdvdvf",MB_OK);
							}
							else
							if((char)pattern[k] == 'Ã' && (char)pattern[k+1] == 'ì')
							{
								strncat(substituteChars,"¨s",2);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}
							else
							if((char)pattern[k] == 'Å' && (char)pattern[k+1] == 'ì')
							{
								strncat(substituteChars,"©ü",2);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}
							else
							if((char)pattern[k] == '¿' && (char)pattern[k+1] == 'ì')
							{
								strncat(substituteChars,"¥s",2);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}
							else
							if((char)pattern[k] == 'À' && (char)pattern[k+1] == 'ì')
							{
								strncat(substituteChars,"¦ü",2);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}
							else
							if((char)pattern[k] == '¦' && (char)pattern[k+1] == 'í')
							{
								strncat(substituteChars,"",1);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}
							else
							
							if((char)pattern[k] == '»' && (char)pattern[k+1] == 'í')
							{
								strncat(substituteChars,"Þ",1);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}
							else
							if((char)pattern[k] == 'Á' && (char)pattern[k+1] == 'í')
							{
								strncat(substituteChars,"á",1);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}
							else
							if((char)pattern[k] == 'Æ' && (char)pattern[k+1] == 'í')
							{
								strncat(substituteChars,"ã",1);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}
							else
							if((char)pattern[k] == 'à' && (char)pattern[k+1] == 'í')
							{
								strncat(substituteChars,"h",1);
								Made_Of_More_Chars = TRUE;
								k = k+2;
							}
							else///////////////////////////if not in above case ie; if character is not made of 2 characters
							for(i=0;i<NOCHARS_SURABHI;i++)
							{
								if( (char)Surabhi[i].vSrg == (char)pattern[k] ) 
									{  
										found = 1 ;
										j=0;
										flag = 0;
										while(Surabhi[i].vKump[j] != -1)
										{	
											//strncat(substituteChars,"",Surabhi[i].vKump[j]);
											substituteChars[strlen(substituteChars)] = (char)Surabhi[i].vKump[j];
											j++;
										}
									}
							}
			
				if(!found)
				{
					//strncat(substituteChars,"",pattern[k]); //If not in Table
					  substituteChars[strlen(substituteChars)] = (char)pattern[k];
				}

				if(Made_Of_More_Chars != TRUE)
				k++;//Set to next element in pattern
			 }
	
		bRet = TRUE;

	return bRet;
}


long __stdcall getRepString(char *pattern,LPSTR repVal,int FontFamily)
{
	strcpy(repVal,"\0");

	for(int i = 0;i<1024;i++)
	{
		substituteChars[i]='\0';
	}

	switch (FontFamily)
	{
	case PRAKASHAK:
		PrakToKuvempu(pattern);
		break;
	case SRG95:
		Srg95ToKuvempu(pattern);
		break;
	case SRG98:
		Srg98ToKuvempu(pattern);
		break;
	case SREELIPI:
		SreeLipiToKuvempu(pattern);
		break;
	case SURABHI:
		SurabhiToKuvempu(pattern);
		break;
	case ANUFONTS:
		AnuToKuvempu(pattern);
		break;
	default:
		break;
	}


	strncat(repVal,substituteChars,strlen(substituteChars));
	
	strncat(repVal,"*#*",3);
	
	return TRUE;
}


INT EXPORTED_DLL_FUNCTION AnuToKuvempu(char* pattern)
{

	int i =0,k = 0,j = 0,bRet = FALSE;
	
	static int found = 0;

		while(k < (int) strlen(pattern))
			{
				found = 0;
				for(i=0;i<NOCHARS_ANU;i++)
				{
					if( Anu[i].vSrg == pattern[k] ) 
						{  
							found = 1 ;
							j=0;
							while(Anu[i].vKump[j] != -1)
							{	
							//	out.write((char *) &Anu[i].vKump[j] ,sizeof Anu[i].vKump[j]);
								substituteChars[strlen(substituteChars)] = (char)Anu[i].vKump[j];
								j++;
							}
						}
				}
				if(!found)
					{
						//out.write((char *) &fchr ,sizeof fchr);
						substituteChars[strlen(substituteChars)] = (char)pattern[k];
					}
			 }
			//::MessageBox(NULL,"File Conversion OK","SRG To KUVEMPU",MB_OK);

	bRet = TRUE;

	return bRet;
}