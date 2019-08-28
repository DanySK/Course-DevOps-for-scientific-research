#/bin/bash
set -e
for pack in 0*
do
    cd $pack
    echo current position:
    pwd
    echo current content:
    ls -ahl
    pdflatex -synctex=1 -interaction=nonstopmode -halt-on-error -shell-escape "${pack}.tex"
    cd ..
done