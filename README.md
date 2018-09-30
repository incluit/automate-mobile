# automate-mobile

## Step by step, ejecutar un proyecto Appium-Java-Junit por consola en AWS Device Farm

#### 1- Configurar amazon CLI:
1. Ingresar al IAM de Amazon y generar el usuario
2. Instalar el CLI de Amazon
3. En el CLI ingresar aws configure:
		-Ingresar en AWS Access Key ID: la clave publica del IAM
		-Ingresar la AWS Secret Access Key:  la clave privada del IAM
		-Ingresar en Default region name: us-west-2
		-Ingresar en Default output format: json

#### 2- Crear proyecto: 
1. Escribir en el CLI: aws devicefarm create-project --name *NombreDelProyecto*
2. Devuelve un json con: “name”, “arn” y “created”
3. Copiar el valor completo de “arn” y reservar

#### 3- Crear el upload del apk (el apk debe estar posicionado desde donde se esta ejecutando la consola):
1. Escribir en el CLI: aws devicefarm create-upload --project-arn *ValorDelPaso2-ArnDelProyecto* --name *NombreDeLaApk* --type ANDROID_APP
2. Devuelve un json con varios valores
3. Copiar el valor completo correspondiente a “url”
4. Escribir en el CLI: curl -T *apkFile* *ValorDeLaUrl*
5. Devuelve un json con varios valores
6. Copiar el valor correspondiente al campo “arn” y reservar

#### 4- Crear upload de los Tests (la carpeta zip-with-dependencies.zip debe estar posicionada desde donde se está ejecutando la consola):
1. Escribir en el CLI: aws devicefarm create-uṕload --project-arn *ValorDelPaso2-ArnDelProyecto* --name “zip-with-dependencies.zip” --type APPIUM_JAVA_JUNIT_TEST_PACKAGE
2. Devuelve un json con varios valores
3. Copiar el valor completo correspondiente a “url”
4. Escribir en el CLI: curl -T zip-with-dependencies.zip *ValorDeLaUrl*
5. Devuelve un json con varios valores
6. Copiar el valor correspondiente al campo “arn” y reservar

#### 5- Crear un device pool (celulares contra los que se quiere correr el apk):
1. Crear un archivo “device-pool-rules.json” que contenga al menos lo siguiente: [{“attribute”: “PLATFORM”, “operator”: “EQUALS”, “value”: “\”ANDROID\””}]
2. Escribir en el CLI: aws devicefarm create-device-pool --project-arn *ValorDelPaso2-ArnDelProyecto* --name *NombreDelPool* --rules device-pool-rules.json
3. Devuelve un json con varios valores
4. Copiar el valor correspondiente al campo “arn” y reservar

#### 6- Crear un run:
1. Escribir en el CLI: aws devicefarm schedule-run --project-arn *ValorDelPaso2-ArnDelProyecto* --app-arn *ValorDelPaso3-ArnDelApk* --device-pool-arn *ValorDelPaso5-ArnDelDP* --name *nombreDelRun* --test type=”APPIUM_JAVA_JUNIT”,testPackageArn=*ValorDelPaso4-ArnDeLosTests*

PD: Los pasos 4 y 6 son los que se van a repetir mayormente, el 4 para actualizar los tests y el 6 para crear la ejecucion.


