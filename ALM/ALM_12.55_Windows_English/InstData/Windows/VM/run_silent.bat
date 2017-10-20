@echo off

rem The format of %TIME% is HH:MM:SS,CS for example 23:59:59,99
set STARTTIME=%TIME%
for /F "tokens=1-4 delims=:.," %%a in ("%STARTTIME%") do (
   set /A "start=(((%%a*60)+1%%b %% 100)*60+1%%c %% 100)*100+1%%d %% 100"
)

echo Installing...
rem print empty line
echo.

rem execute installer
ALM_installer.exe -i silent
rem notify installation completed
if %ERRORLEVEL%==0 (
	echo Installation completed.
	) else if %ERRORLEVEL%==1 (
	echo Installation finished successfully, but some errors occurred during the install. Check log for details.
	) else (
	echo Installation failed. Check log file for details.)
rem print empty line
echo.

rem
rem calculate elapsed time
rem
set ENDTIME=%TIME%
for /F "tokens=1-4 delims=:.," %%a in ("%ENDTIME%") do (
   set /A "end=(((%%a*60)+1%%b %% 100)*60+1%%c %% 100)*100+1%%d %% 100"
)


rem output as time
echo STARTTIME: %STARTTIME%
echo ENDTIME: %ENDTIME%

set /A elapsed=end-start

rem Show elapsed time:
set /A hh=elapsed/(60*60*100), rest=elapsed%%(60*60*100), mm=rest/(60*100), rest%%=60*100, ss=rest/100, cc=rest%%100
if %mm% lss 10 set mm=0%mm%
if %ss% lss 10 set ss=0%ss%
if %cc% lss 10 set cc=0%cc%

rem
rem outputing
rem
echo DURATION: %hh%:%mm%:%ss%,%cc%
