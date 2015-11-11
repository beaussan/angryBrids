# angryBrids

Groupe : K2

Liste des membres : 

* BEAUSSART Nicolas
* DELTOUR Lucas
* DUSART Bastien
* D'HOOP Benjamin
* SOLER Eddy

## Installer gradle

Si vous êtes sur une machine avec le proxy de Lille 1 : ` ./gradleWProxy `

sinon si vous êtes sous windows :  ` gradlew.bat `

sinon : ` ./gradlew `

### Tasks

#### pour run :
`
./gradlew run
`
#### pour les tests :
`
./gradlew test
`

le rapport généré est dans : build/reports/index.html

#### pour générer le jar :
Pour juste le jar sans les librairies : 

`
./gradlew jar
`

Pour le jar complet avec dépendances : 

`
./gradlew shadowJar
`

Il se trouve dans : build/libs

#### pour générer la javadoc :
`
./gradlew javadoc
`

Il se trouve dans : build/docs

#### pour générer un zip distribuable :

`
./gradlew distZip
`


Il se trouve dans /build/distributions


## Importer dans un IDE

### Eclipse

`
gradlew eclipse
`
puis il suffit d'ouvrir le projet dans Eclipse

Ou le plugin http://www.vogella.com/tutorials/EclipseGradle/article.html existe.

### IntelliJ IDEA

ouvrir le build.gradle
