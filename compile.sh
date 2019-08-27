#/bin/bash
set -e
for pack in 0*
do
    cd $pack
    ls -ahl
    pdflatex -interaction=nonstopmode -halt-on-error -shell-escape "${pack}.tex"
    cd ..
done
