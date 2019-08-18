@echo off

if '%1' == [] (
    echo pas d'argument
	goto :EOF
)

set prefixe=%1

if [%2]==[] (
	echo pas d'argument
	goto :EOF
)

set extension=%2

if not [%3]==[] echo trop d'arguments

if exist *.%extension% (
	set numero = 0
	for %%a in (*.%extension%) do call :traitement %%a
) else (
	echo pas de fichier abec l'extension %extension%
)

goto :EOF

:traitement
set /a numero+=1
rename %1 %prefixe%%numero%.%extension%
