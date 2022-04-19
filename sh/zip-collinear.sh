cd ./src/main/java/AlgorithmsPrincetonCourse/Assignments/collinear
mkdir -p collinear
rm -fr ./collinear.zip # remover um zip anterior

for filename in *.java; do 
  if [[ $filename != 'LineSegment.java' ]]; then
  # if [ $filename != 'LineSegment.java' ]; then # aparentemente funciona tbm
    echo 'processing' ${filename} 
    cp ./${filename} ./collinear
    sed -i '/package AlgorithmsPrincetonCourse.Assignments.collinear;/d' ./collinear/${filename}
  fi
done

zip -r collinear.zip ./collinear
rm -r ./collinear

# Pra debugar
cp ./collinear.zip ~/Desktop/collinear.zip
