@echo off
set ncoup=5
set /a x=%random%%%21
rem echo l'entier a trouver est : %x%
rem pause
title =---------------------------FUCKING BEST GAME EVER------------------------------
cls

:debut

echo --------------------------------------------------------------------------------
echo            Jeu qui conciste a trouver un entier compris entre 0 et 20
echo --------------------------------------------------------------------------------

if %ncoup% equ 0 ( 
	echo PERDU !
	pause
	cls
	goto :EOF)

set /p test=Il vous reste %ncoup% test(s). Entrer un nombre :
if /i %test% lss %x% ( 
	echo trop petit.
	pause
	set /a ncoup-=1
	cls
	goto debut )

if /i %test% gtr %x% ( 
	echo trop grand.
	pause
	set /a ncoup-=1
	cls
	goto debut )

if /i %test% equ %x% ( 
	echo TROUVE !
	pause
	cls
	goto :EOF )
pause