*******README Base de datos
Dentro de esta carpeta hay dos archivo para la creación de la base de datos. El primero "BaseDeDatos_MySQL_ESTRUCTURA_V3" contiene la estructura de la base de datos. El segundo "BasedeDatos_MySQL_DATA" contiene los datos iniciales y necesarios de la base de datos y que no son modificables desde el programa.

Para el acceso a la base de datos se usaron tres usuario creados en la base de datos o servidor. Todos los usuario tienen permiso de select en la base de datos. Ningun usuario tiene permisos de delete.

Con este usuario accede el usuario coordinador a la base de datos.Tiene permisos de update e insert en algunas tablas.
Usuario: "UserCoordinator";
Contraseña: "uC102*lPg";

Con este usuario accede el usuario estandar a la base de datos.Tiene permisos de update solo a la tabla usuarios y solicitudes e insert en algunas tablas.
Usuario: "UserStandard";
Contraseña: "Us58*uQL";


Con este usuario accede desde la parte del login a la base de datos.Tiene permisos de update e insert a la tabla usuarios.
Usuario: "SeeTableUser";
Contraseña: "ISsRD1*y";

Fue necesario dar algunos permisos en algunas funciones o procedimientos de la base de datos a estos usuarios. Por ejemplo: 

GRANT EXECUTE ON PROCEDURE Horarios_Tics_y_Laboratorios.InforporEspacio TO UserStandard@'%';
GRANT EXECUTE ON PROCEDURE Horarios_Tics_y_Laboratorios.Espacios_horas TO UserStandard@'%';
GRANT EXECUTE ON FUNCTION Horarios_Tics_y_Laboratorios.cambiar_estado TO UserStandard@'%';

