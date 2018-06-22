@echo off
rem v 2.6 Feb 3 2012


rem See comments in setFDKPaths.cmd

call "%~dp0setFDKPaths.cmd"

%AFDKO_Python% %AFDKO_SCRIPTS%\ProofPDF.py -fontplot --drawGlyph_CenterMarksWithBox 1 --drawGlyph_EMBox 0 --drawGlyph_XAdvance 0  --drawMeta_SideBearings 0 %*
