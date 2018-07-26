@echo off

REM ------------------------------------------------------------------------
REM only support Windows
REM product:smartlog
REM components:flume-watch
REM authour:chengxj
REM date:2018/05/23
REM ------------------------------------------------------------------------

if "%OS%"=="Windows_NT" @setlocal

set APP_MAINCLASS=com.ultrapower.flume.watch.FlumeWatch
set "CURRENT_DIR=%cd%"
set APP_HOME=%CURRENT_DIR%

:checkJava
set _JAVACMD=%JAVACMD%

if "%JAVA_HOME%" == "" goto noJavaHome
if not exist "%JAVA_HOME%\bin\java.exe" goto noJavaHome
if "%_JAVACMD%" == "" set _JAVACMD=%JAVA_HOME%\bin\java.exe
goto runAnt

:noJavaHome
if "%_JAVACMD%" == "" set _JAVACMD=java.exe
echo.
echo Warning: JAVA_HOME environment variable is not set.
echo.

:runAnt

if "%FLUME_WATCH_OPTS%" == "" set FLUME_WATCH_OPTS=-Xms128m -Xmx128m

"%_JAVACMD%" %FLUME_WATCH_OPTS% -cp %APP_HOME%/../conf;%APP_HOME%/../lib/* %APP_MAINCLASS%

goto end


:end
set _JAVACMD=
if "%OS%"=="Windows_NT" @endlocal
pause

:mainEnd

