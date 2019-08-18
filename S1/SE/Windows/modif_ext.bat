@echo off
set /p ext1=Entrer l'extension recherche : 
set /p ext2=Entrer l'extension voulu : 
if exist *.%ext1% (
	for /r %%v in (*.%ext1%) do echo %%~nv.%ext1%
	for /r %%v in (*.%ext1%) do rename %%~nv.%ext1% %%~nv.%ext2%
	for /r %%v in (*.%ext2%) do echo %%~nv.%ext2%
) else ( echo il n'y a aucun fichier de ce type)