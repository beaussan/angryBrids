# angryBrids

Groupe : K2

Liste des membres : 

* BEAUSSART Nicolas
* DELTOUR Lucas
* DUSSART Bastien
* D'HOOP Benjamin
* SOLER Eddy

## Installer gradle

Si vous êtes sur une machine avec le proxy de Lille 1 : 
```
./gradleWProxy
```

sinon si vous êtes sous windows : 
```
gradlew.bat
```

sinon :
```
./gradlew
 ```

### Tasks

#### pour run : ```
./gradlew run
```
#### pour les tests : ```
./gradlew test
```

le raport générer est dans : build/reports/index.html

#### pour générer le jar :  ```
./gradlew jar
```

Il se trouve dans : build/libs

#### pour générer la javadoc : ```
./gradlew javadoc
```

il se trouve dans /build/docs


## Importer dans un IDE

### Eclipse

```
gradlew eclipse
```
puis il sufit d'ouvrir le projet dans Eclipse

### IntelliJ IDEA

ouvrir le build.gradle