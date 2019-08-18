@echo off

if not "%4" == "" ( 
	echo TROP D'ARGUMENTS
	goto fin)
if "%3" == "" ( 
	echo PAS ASSEZ D'ARGUMENTS
	goto fin)
if not "%3" == "" ( 
	if %1 == %2 ( 
	    if %2 == %3 ( 
			echo Toutes identiques
		) else ( 
			echo 3 ) 
	) else ( 
		if %2 == %3 ( 
			echo 1 
		) else ( 
			if %1 == %3 ( 
				echo 2 
			) else ( 
                echo toutes differentes
            ) 
        ) 
    ) 
) 

:fin
pause

