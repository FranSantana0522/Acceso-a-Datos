package com.accesoadatos.ProyectoMongo.mongodb;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;

import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.elemMatch;
import static com.mongodb.client.model.Updates.addToSet;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;
import static com.mongodb.client.model.Accumulators.*;
import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Sorts.*;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Arrays;
import java.util.List;

public class MongoDB {

	private MongoClient mongoClient;
	private MongoDatabase db;

	// Contructor con la conexion a la bd
	public MongoDB() {
		ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
		MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(connectionString).build();
		mongoClient = MongoClients.create(settings);
		db = mongoClient.getDatabase("ProyectoMongo");
	}

	// Creamos las coleciones con un dato dentro
	public void crearColecciones() {
		// Primera coleccion es profesores y su dependencia a los departamentos a los
		// que pertenece
		MongoCollection<Document> profesores = db.getCollection("profesores");
		Document docProfesores = new Document("id", 456).append("DNI", "87654321Z").append("Interino", false)
				.append("Guardias", null).append("Telefonos", new Document("Telefono Movil", "694 39 21 65"))
				.append("Cursos", Arrays.asList("1ESO A", "3ESO B", "2 BACH"))
				.append("dependencia", Arrays.asList(new Document("departamento", "Matematicas"),
						new Document("departamento", "Ciencias Sociales")));
		profesores.insertOne(docProfesores);
		// Segunda coleccion es alumnos y su dependencia con los profesores que le
		// imparte clase
		MongoCollection<Document> alumnos = db.getCollection("alumnos");
		Document docAlumnos = new Document("id", 123).append("DNI", "12345678A").append("Mayor de edad", true)
				.append("Matricula de honor", null)
				.append("Telefono padres",
						new Document("Telefono Madre", "643 45 34 21").append("Telefono Padre", "657 38 21 69"))
				.append("Nota trimestres", Arrays.asList(4, 5, 3)).append("profesor", 456);
		alumnos.insertOne(docAlumnos);
	}

	// Insertamos mas datos extras para las colecciones
	public void insertarDatos() {
		// PROFESORES
		MongoCollection<Document> profesores = db.getCollection("profesores");
		Document docProfesor2 = new Document("id", 457).append("DNI", "76543214Y").append("Interino", true)
				.append("Guardias", null).append("Telefonos", new Document("Telefono Movil", "694 39 21 66"))
				.append("Cursos", Arrays.asList("4ESO A", "2 BACH")).append("dependencia", Arrays
						.asList(new Document("departamento", "Lengua"), new Document("departamento", "Historia")));
		profesores.insertOne(docProfesor2);

		Document docProfesor3 = new Document("id", 458).append("DNI", "65432128X").append("Interino", false)
				.append("Guardias", null).append("Telefonos", new Document("Telefono Movil", "694 39 21 67"))
				.append("Cursos", Arrays.asList("1ESO B", "4ESO B")).append("dependencia",
						Arrays.asList(new Document("departamento", "Fisica"), new Document("departamento", "Quimica")));
		profesores.insertOne(docProfesor3);

		Document docProfesor4 = new Document("id", 459).append("DNI", "54321927W").append("Interino", true)
				.append("Guardias", null).append("Telefonos", new Document("Telefono Movil", "694 39 21 68"))
				.append("Cursos", Arrays.asList("3ESO C", "1 BACH")).append("dependencia", Arrays
						.asList(new Document("departamento", "Biologia"), new Document("departamento", "Geologia")));
		profesores.insertOne(docProfesor4);

		// ALUMNOS
		MongoCollection<Document> alumnos = db.getCollection("alumnos");
		Document docAlumno2 = new Document("id", 124).append("DNI", "98765432B").append("Mayor de edad", false)
				.append("Matricula de honor", null)
				.append("Telefono padres",
						new Document("Telefono Madre", "643 45 34 22").append("Telefono Padre", "657 38 21 70"))
				.append("Nota trimestres", Arrays.asList(7, 5, 9)).append("profesor", Arrays.asList(459, 457));
		alumnos.insertOne(docAlumno2);

		Document docAlumno3 = new Document("id", 125).append("DNI", "87654321C").append("Mayor de edad", false)
				.append("Matricula de honor", null)
				.append("Telefono padres",
						new Document("Telefono Madre", "643 45 34 23").append("Telefono Padre", "657 38 21 71"))
				.append("Nota trimestres", Arrays.asList(5, 3, 6)).append("profesor", Arrays.asList(458, 457));
		alumnos.insertOne(docAlumno3);

		Document docAlumno4 = new Document("id", 126).append("DNI", "76543214D").append("Mayor de edad", false)
				.append("Matricula de honor", null)
				.append("Telefono padres",
						new Document("Telefono Madre", "643 45 34 24").append("Telefono Padre", "657 38 21 72"))
				.append("Nota trimestres", Arrays.asList(5, 5, 6)).append("profesor", Arrays.asList(458, 457));
		alumnos.insertOne(docAlumno4);

		Document docAlumno5 = new Document("id", 127).append("DNI", "65432127E").append("Mayor de edad", true)
				.append("Matricula de honor", null)
				.append("Telefono padres",
						new Document("Telefono Madre", "643 45 34 25").append("Telefono Padre", "657 38 21 73"))
				.append("Nota trimestres", Arrays.asList(1, 2, 1)).append("profesor", Arrays.asList(459, 457, 458));
		alumnos.insertOne(docAlumno5);

		Document docAlumno6 = new Document("id", 128).append("DNI", "54321375F").append("Mayor de edad", true)
				.append("Matricula de honor", null)
				.append("Telefono padres",
						new Document("Telefono Madre", "643 45 34 26").append("Telefono Padre", "657 38 21 74"))
				.append("Nota trimestres", Arrays.asList(8, 7, 8))
				.append("profesor", Arrays.asList(459, 457, 456, 458));
		alumnos.insertOne(docAlumno6);
	}

	// Consultas basicas con selectores de busqueda
	public void consultasBasicas() {
		// Consulta para encontrar todos los profesores
		MongoCollection<Document> profesoresCollection = db.getCollection("profesores");
		FindIterable<Document> profesores = profesoresCollection.find();
		System.out.println("Profesores:");
		for (Document profesor : profesores) {
			System.out.println(profesor.toJson());
		}
		System.out.println("----------------------");

		// Consulta para encontrar todos los alumnos
		MongoCollection<Document> alumnosCollection = db.getCollection("alumnos");
		FindIterable<Document> alumnos = alumnosCollection.find();
		System.out.println("Alumnos:");
		for (Document alumno : alumnos) {
			System.out.println(alumno.toJson());
		}
		System.out.println("----------------------");

		// Consulta para encontrar alumnos mayores de edad
		FindIterable<Document> alumnosMayoresEdad = alumnosCollection.find(eq("Mayor de edad", true));
		System.out.println("Alumnos mayores de edad:");
		for (Document alumno : alumnosMayoresEdad) {
			System.out.println(alumno.toJson());
		}
		System.out.println("----------------------");

		// Consulta para encontrar profesores con cursos específicos
		FindIterable<Document> profesoresConCursos = profesoresCollection.find(in("Cursos", "1ESO A", "2 BACH"));
		System.out.println("Profesores con cursos 1ESO A o 2 BACH:");
		for (Document profesor : profesoresConCursos) {
			System.out.println(profesor.toJson());
		}
		System.out.println("----------------------");

		// Consulta para encontrar alumnos con notas superiores a 7 en algún trimestre
		Bson filter = gt("Nota trimestres", 7);
		FindIterable<Document> alumnosNotasAltas = alumnosCollection.find(filter);

		System.out.println("Alumnos con notas superiores a 7 en algún trimestre:");
		for (Document alumno : alumnosNotasAltas) {
			System.out.println(alumno.toJson());
		}
		System.out.println("----------------------");

		// Consulta para encontrar profesores que no sean interinos
		FindIterable<Document> profesoresFijos = profesoresCollection.find(ne("Interino", true));
		System.out.println("Profesores fijos (no interinos):");
		for (Document profesor : profesoresFijos) {
			System.out.println(profesor.toJson());
		}
		System.out.println("----------------------");

	}

	// Actualizaciones a los datos de las colleciones
	public void actualizaciones() {
		// Actualizacion de un profesor a interino true
		MongoCollection<Document> profesoresCollection = db.getCollection("profesores");
		profesoresCollection.updateOne(eq("id", 456), set("Interino", true));
		System.out.println("Profesor con id 456 es ahora interino");

		// Actualizacion de multiples alumnos a mayor de edad
		MongoCollection<Document> alumnosCollection = db.getCollection("alumnos");
		alumnosCollection.updateMany(eq("Mayor de edad", false), set("Mayor de edad", true));
		System.out.println("Todos los alumnos menores de edad pasan a mayor de edad");

		// Incremento del curso de un profesor en 1
		profesoresCollection.updateOne(eq("id", 457), addToSet("Cursos", "2ESO B"));
		System.out.println("Profesor con id 457 tiene un curso mas");

		// Renombrar un campo de los alumnos
		alumnosCollection.updateOne(eq("id", 124), rename("Telefono padres", "Telefonos padres"));
		System.out.println("Se ha renombrado el campo 'Telefono padres' a 'Telefonos padres'");

		// Eliminar un curso de un profesor
		profesoresCollection.updateOne(eq("id", 458), pull("Cursos", "1ESO B"));
		System.out.println("Profesor con id 458 ya no imparte clases en 1ESO B");

	}

	// Consultas y modificaciones a los arrays
	public void conModArrays() {
		// Consulta para encontrar todos los profesores que imparten clases de
		// Matematicas
		MongoCollection<Document> profesoresCollection = db.getCollection("profesores");
		FindIterable<Document> profesoresMatematicas = profesoresCollection
				.find(eq("dependencia.departamento", "Matematicas"));

		System.out.println("Profesores que imparten clases de Matematicas:");
		for (Document profesor : profesoresMatematicas) {
			System.out.println(profesor.toJson());
		}
		System.out.println("----------------------");

		// Modificacion para agregar un nuevo curso a un profesor especifico
		profesoresCollection.updateOne(eq("id", 456), addToSet("Cursos", "4ESO A"));
		System.out.println("Profesor con id 456 ahora imparte clase en 4ESO A");

		// Modificacion para eliminar un curso de todos los profesores que lo imparten
		profesoresCollection.updateMany(all("Cursos", "1ESO A"), pull("Cursos", "1ESO A"));
		System.out.println("Profesores que impartan a 1ESO A dejaran de impartir a ese curso");

		// Consulta para encontrar todos los alumnos que tienen una nota mayor a 5 en
		// algun trimestre
		MongoCollection<Document> alumnosCollection = db.getCollection("alumnos");
		Bson filter = gt("Nota trimestres", 5);
		FindIterable<Document> alumnosNotasAltas = alumnosCollection.find(filter);

		System.out.println("Alumnos con notas mayores a 5 en algún trimestre:");
		for (Document alumno : alumnosNotasAltas) {
			System.out.println(alumno.toJson());
		}
		System.out.println("----------------------");

		// Modificacion para incrementar todas las notas de un alumno en un punto
		// Recuperar el documento del alumno
		Document alumno = alumnosCollection.find(eq("id", 123)).first();

		// Obtener el array de notas trimestrales
		List<Integer> notasTrimestres = alumno.getList("Nota trimestres", Integer.class);

		// Iterar sobre el array y aumentar cada nota en 1 punto
		for (int i = 0; i < notasTrimestres.size(); i++) {
			notasTrimestres.set(i, notasTrimestres.get(i) + 1);
		}

		// Actualizar el documento con el nuevo array de notas trimestrales
		// incrementadas
		alumnosCollection.updateOne(eq("id", 123), set("Nota trimestres", notasTrimestres));

		System.out.println("Notas trimestrales del alumno con id 123 incrementadas en 1 punto.");
	}

	// Borrado de documentos
	public void borradoDoc() {
		MongoCollection<Document> profesoresCollection = db.getCollection("profesores");
		profesoresCollection.deleteOne(eq("id", 456));
		System.out.println("Profesor con id 456 eliminado");

		MongoCollection<Document> alumnoUpdate = db.getCollection("alumnos");
		alumnoUpdate.updateOne(eq("id", 123), set("Mayor de edad", false));
		System.out.println("Alumno con id " + 123 + " ahora es menor de edad");

		MongoCollection<Document> alumnoEliminar = db.getCollection("alumnos");
		alumnoEliminar.deleteMany(eq("Mayor de edad", false));
		System.out.println("Todos los alumnos menores de edad han sido eliminados");
	}

	// Consultas de agregacion pipeline
	public void consultasPipeline() {
		MongoCollection<Document> profesores = db.getCollection("profesores");
		AggregateIterable<Document> results = profesores.aggregate(Arrays.asList(
				lookup("alumnos", "id", "profesor", "alumnos"), unwind("$alumnos"),
				group("$id", Accumulators.push("notas_alumnos", "$alumnos.Nota trimestres")),
				project(fields(include("_id"), include("notas_alumnos"),
						computed("total_notas", new Document("$reduce",
								new Document("input", "$notas_alumnos").append("initialValue", Arrays.asList()).append(
										"in", new Document("$concatArrays", Arrays.asList("$$value", "$$this"))))))),
				project(fields(include("_id"), computed("media_notas", new Document("$avg", "$total_notas")))),
				sort(descending("media_notas"))));

		System.out.println("Media total de las notas de los alumnos por profesor (de mayor a menor):");
		for (Document doc : results) {
			System.out.println(doc.toJson());
		}
	}

	// Consultas para arrays usando funciones
	public void consultasArrays() {
		// Consulta para encontrar profesores que imparten clases de Matematicas
		MongoCollection<Document> profesoresCollection = db.getCollection("profesores");
		FindIterable<Document> profesoresMatematicas = profesoresCollection
				.find(in("dependencia.departamento", "Matematicas"));
		System.out.println("Profesores que imparten clases de Matematicas:");
		for (Document profesor : profesoresMatematicas) {
			System.out.println(profesor.toJson());
		}
		System.out.println("No deberia salir profesor ya que fue eliminado antes");
		System.out.println("----------------------");

		// Consulta para encontrar todos los alumnos que tienen una nota mayor a 5 en
		// algún trimestre
		MongoCollection<Document> alumnosCollection = db.getCollection("alumnos");
		Bson filter = gt("Nota trimestres", 5);
		FindIterable<Document> alumnosNotasAltas = alumnosCollection.find(filter);

		System.out.println("Alumnos con notas mayores a 5 en algún trimestre:");
		for (Document alumno : alumnosNotasAltas) {
			System.out.println(alumno.toJson());
		}
		System.out.println("----------------------");

		// Modificacion para incrementar todas las notas de un alumno en un punto
		// Recuperar el documento del alumno
		Document alumno = alumnosCollection.find(eq("id", 124)).first();

		// Obtener el array de notas trimestrales
		List<Integer> notasTrimestres = alumno.getList("Nota trimestres", Integer.class);

		// Iterar sobre el array y aumentar cada nota en 1 punto
		for (int i = 0; i < notasTrimestres.size(); i++) {
			notasTrimestres.set(i, notasTrimestres.get(i) + 1);
		}

		// Actualizar el documento con el nuevo array de notas trimestrales
		// incrementadas
		alumnosCollection.updateOne(eq("id", 124), set("Nota trimestres", notasTrimestres));

		System.out.println("Notas trimestrales del alumno con id 124 incrementadas en 1 punto.");
	}

	// Consultas sobre documentos enlazados
	public void consultasDocumentosEnl() {
		// Consulta para encontrar alumnos y los profesores que les imparten clases
		MongoCollection<Document> alumnosCollection = db.getCollection("alumnos");
		FindIterable<Document> alumnos = alumnosCollection.find();

		System.out.println("Alumnos y sus profesores:");
		for (Document alumno : alumnos) {
			System.out.println("Alumno: " + alumno.toJson());
			// Obtenemos la lista de profesores del alumno
			List<Integer> profesoresIds = (List<Integer>) alumno.get("profesor");
			// Consultamos los profesores correspondientes a esos ids
			MongoCollection<Document> profesoresCollection = db.getCollection("profesores");
			FindIterable<Document> profesores = profesoresCollection.find(in("id", profesoresIds));
			System.out.println("Profesores:");
			for (Document profesor : profesores) {
				System.out.println(profesor.toJson());
			}
			System.out.println("----------------------");
		}
	}

	// Método para borrar todos los documentos de una colección
	public void borrarDocumentos(String nombreColeccion) {
		// Obtener la colección
		MongoCollection<Document> coleccion = db.getCollection(nombreColeccion);

		// Borrar todos los documentos de la colección
		coleccion.deleteMany(new Document());

		System.out.println("Todos los documentos de la colección '" + nombreColeccion + "' han sido eliminados.");
	}

	// Cerramos la conexion con la bd
	public void cerrarConexion() {
		mongoClient.close();
		System.out.println("Conexion cerrada");
	}

}
