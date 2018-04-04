call runcrud.bat

if %ERRORLEVEL% == 0 goto start
echo.
echo runcrud.bat FAILED goto fail
goto fail

:start
start "Starting chrome..." "C:\Users\admin.admin-Komputer\Desktop\Google_Chrome.lnk" " http://localhost:8080/crud/v1/task/getTasks"
goto end

:fail
echo.
echo Something went wrong!

:end
echo.
echo Work is finished!