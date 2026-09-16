@echo off
cd /d "%~dp0"
mkdir out 2>nul
setlocal EnableDelayedExpansion
set "files="
for /r src %%f in (*.java) do set "files=!files! "%%~ff""
javac -d out !files!
java -cp out com.pixelshop.App
