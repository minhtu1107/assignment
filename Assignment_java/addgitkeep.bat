@echo off
setlocal
for /r "%cd%" /d %%F in (.) do dir /b "%%F" | findstr "^" >nul || echo *>%%~fF\.gitkeep