call runcrud.bat
if if "%ERRORLEVEL%" == "0" goto browser
echo.
echo Problem with running script.
goto fail

:browser
opera "http://localhost:8080/crud/v1/task/getTasks"

if "%ERRORLEVEL%" == "0" goto end
echo.
echo Problem with running opera browser.
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished
