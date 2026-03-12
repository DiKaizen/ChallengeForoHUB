ForoHub API

ForoHub es una API REST desarrollada con Java y Spring Boot que permite gestionar tópicos dentro de un foro.
Los usuarios pueden crear, consultar, actualizar y eliminar tópicos.

El proyecto implementa autenticación y autorización mediante JWT, además de persistencia de datos en MySQL.

Funcionalidades

La API permite:

Registrar nuevos tópicos

Listar tópicos registrados

Consultar un tópico por ID

Actualizar un tópico por ID

Eliminar tópicos por ID

Autenticación de usuarios con JWT


Tecnologías utilizadas

Java

Spring Boot

Spring Data JPA

Spring Security

JWT (JSON Web Token)

MySQL


Configuración del proyecto

Ingresar un usuario manualmente a traves de la base de datos

Este debe tener un id, un nombre, y una contraseña encriptada con Bcrypt

Configurar la base de datos en:

src/main/resources/application.properties


Autenticación

La API utiliza JWT (JSON Web Token) para autenticar usuarios.

Para acceder a los endpoints protegidos se debe:

Autenticarse con usuario y contraseña.

Obtener el token JWT.

Enviar el token en las siguientes solicitudes:

Authorization: Bearer TOKEN


Endpoints principales

Método	Endpoint	Descripción
POST	/login	Autenticar usuario
POST	/topicos	Crear un nuevo tópico
GET	/topicos	Listar tópicos
GET	/topicos/{id}	Obtener tópico por ID
PUT	/topicos/{id}	Actualizar tópico por ID
DELETE	/topicos/{id}	Eliminar tópico por ID

Ejecutar el proyecto

Clonar el repositorio

git clone https://github.com/DiKaizen/ChallengeForoHUB.git

Ejecutar la aplicación

Probar la API con herramientas como:

Insomnia
