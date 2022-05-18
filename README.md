# JOBarcelona-22-Back-end
Reto clasificatorio que forma parte del hackathon online de JOBarcelona ’22. 

Reto de Back-end
El equipo de JOBX necesita implementar un sistema de autenticación (Auth) utilizando Jason Web Token para seguir de forma segura.

User stories / Objetivos

✅ Task 1 → Que se conecte al puerto: 3030

✅ Task 2 → Las variables de entorno no se deben subir a github, pero tiene que haber un template que permita conocer cuales son las necesarias.

✅ Task 3 → Las rutas de auth tiene que permitir registrar y logear usuarios: Una ruta para el registro /signup, Una ruta para el login /login

✅ Task 4 → Tanto la ruta de login como la de registro deben enviar el token para poder entrar en las demás rutas.

✅ Task 5 → Además, se necesita una ruta que devuela toda la lista de users que haya para que desde el backoffice de JOBX puedan controlar el crecimiento. Esta ruta tiene que estar protegida y solo se dará acceso a un usuario con rol de admin y con los credenciales que se encuentran encriptados en el documento: ruta: /users

✅ Task 6 → Un user tiene como parámetros obligatorios: username (tiene que ser único), email (tiene que seguir el patrón de correo y ser único), password (tiene que tener mínimo de 8 carácteres, incluir una mayúscula y un número).

Para poder finalizar la implementación con éxito tendrás que descifrar el código de encriptación y desbloquear el documento dónde se encuentran las librerías secretas, que son las que se se están usando para documentar y para el diseño del componente.
