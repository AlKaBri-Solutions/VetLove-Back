package com.vetlove.demo.Entidad;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import com.vetlove.demo.Repositorio.ClienteRepositorio;
import com.vetlove.demo.Repositorio.EnfermedadRepositorio;
import com.vetlove.demo.Repositorio.EspecialidadRepositorio;
import com.vetlove.demo.Repositorio.EstadoMasRepositorio;
import com.vetlove.demo.Repositorio.EstadoVetRepositorio;
import com.vetlove.demo.Repositorio.MascotaRepositorio;
import com.vetlove.demo.Repositorio.MedicamentoRepositorio;
import com.vetlove.demo.Repositorio.PrioridadRepositorio;
import com.vetlove.demo.Repositorio.TratamientoRepositorio;
import com.vetlove.demo.Repositorio.VeterinarioRepositorio;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DatabaseInit implements ApplicationRunner {

        @Autowired
        ClienteRepositorio repoCliente;

        @Autowired
        MascotaRepositorio repoMascota;

        @Autowired
        VeterinarioRepositorio repoVeterinario;

        @Autowired
        EstadoMasRepositorio repoEstadoMas;

        @Autowired
        MedicamentoRepositorio repoMedicamento;

        @Autowired
        PrioridadRepositorio repoPrioridad;

        @Autowired
        EnfermedadRepositorio repoEnfermedad;

        @Autowired
        TratamientoRepositorio repoTratamiento;

        @Autowired
        EspecialidadRepositorio repoEspecialidad;

        @Autowired
        EstadoVetRepositorio repoEstadoVet;

        @Override
        public void run(ApplicationArguments args) throws Exception {
                repoCliente.save(
                                new Cliente("1125248041", "Alejandro Barragán", "alejo190404@gmail.com", "3017202327"));
                repoCliente.save(new Cliente("1001572832", "Laura Karara", "karara02@gmail.com", "3022678421"));
                repoCliente.save(new Cliente("1000000241", "Pipe Briñex", "brinez1907@gmail.com", "3142211457"));
                repoCliente.save(
                                new Cliente("1000000123", "Laura Rodriguez", "rodriguezlaura@gmail.com", "3003003030"));
                repoCliente.save(new Cliente("1000000789", "Maria Gomez", "mariagomez@yahoo.com", "3203203232"));
                repoCliente.save(new Cliente("1000000456", "Juan Perez", "juanperez@hotmail.com", "3103103131"));
                repoCliente.save(
                                new Cliente("1000000987", "Carlos Sanchez", "carlossanchez@outlook.com", "3303303333"));
                repoCliente.save(new Cliente("1000000654", "Ana Martinez", "anamartinez@gmail.com", "3403403434"));
                repoCliente.save(new Cliente("1000000321", "Pedro Lopez", "pedrolopez@hotmail.com", "3503503535"));
                repoCliente.save(new Cliente("1000000876", "Luisa Ramirez", "luisaramirez@yahoo.com", "3603603636"));
                repoCliente.save(new Cliente("1000000543", "Jorge Hernandez", "jorgehernandez@outlook.com",
                                "3703703737"));
                repoCliente.save(new Cliente("1000000234", "Sofia Castro", "sofiacastro@gmail.com", "3803803838"));
                repoCliente.save(new Cliente("1000000765", "Andres Diaz", "andresdiaz@hotmail.com", "3903903939"));
                repoCliente.save(
                                new Cliente("1000000345", "Gabriela Torres", "gabrielatorres@yahoo.com", "4004004040"));
                repoCliente.save(new Cliente("1000000678", "Ricardo Pardo", "ricardopardo@outlook.com", "4104104141"));
                repoCliente.save(new Cliente("1000000456", "Camila Duque", "camiladuque@gmail.com", "4204204242"));
                repoCliente.save(new Cliente("1000000987", "Daniel Rojas", "danielrojas@hotmail.com", "4304304343"));
                repoCliente.save(new Cliente("1000000789", "Valentina Duarte", "valentinaduarte@yahoo.com",
                                "4404404444"));
                repoCliente.save(new Cliente("1000000654", "Diego Castro", "diegocastro@outlook.com", "4504504545"));
                repoCliente.save(new Cliente("1000000876", "Laura Perez", "lauraperez@gmail.com", "4604604646"));
                repoCliente.save(new Cliente("1000000999", "Elena Sánchez", "elenasanchez@gmail.com", "3713713737"));
                repoCliente.save(new Cliente("1000001000", "Javier García", "javiergarcia@yahoo.com", "3803803838"));
                repoCliente.save(new Cliente("1000001001", "Andrea Fernandez", "afernandez@hotmail.com", "3903903939"));
                repoCliente.save(new Cliente("1000001002", "Santiago Diaz", "santiagodiaz@gmail.com", "4004004040"));
                repoCliente.save(new Cliente("1000001003", "Paula Ruiz", "paularuiz@yahoo.com", "4104104141"));
                repoCliente.save(new Cliente("1000001004", "Mario Torres", "mariotorres@hotmail.com", "4204204242"));
                repoCliente.save(new Cliente("1000001005", "Lucia Navarro", "lucianavarro@gmail.com", "4304304343"));
                repoCliente.save(new Cliente("1000001006", "Diego Jimenez", "diegojimenez@yahoo.com", "4404404444"));
                repoCliente.save(new Cliente("1000001007", "Carmen Castro", "carmencastro@hotmail.com", "4504504545"));
                repoCliente.save(new Cliente("1000001008", "Roberto Molina", "robertomolina@gmail.com", "4604604646"));
                repoCliente.save(
                                new Cliente("1000001009", "Patricia Vargas", "patriciavargas@yahoo.com", "4704704747"));
                repoCliente.save(new Cliente("1000001010", "Jorge Hernandez", "jorgehernandez@hotmail.com",
                                "4804804848"));
                repoCliente.save(
                                new Cliente("1000001011", "Natalia Alvarez", "nataliaalvarez@gmail.com", "4904904949"));
                repoCliente.save(new Cliente("1000001012", "Gonzalo Romero", "gonzaloromero@yahoo.com", "5005005050"));
                repoCliente.save(new Cliente("1000001013", "Rocio Flores", "rocioflores@hotmail.com", "5105105151"));
                repoCliente.save(
                                new Cliente("1000001014", "Fernando Medina", "fernandomedina@gmail.com", "5205205252"));
                repoCliente.save(
                                new Cliente("1000001015", "Lorena Guerrero", "lorenaguerrero@yahoo.com", "5305305353"));
                repoCliente.save(new Cliente("1000001016", "Manuel Castro", "manuelcastro@hotmail.com", "5405405454"));
                repoCliente.save(new Cliente("1000001017", "Esther Morales", "esthermorales@gmail.com", "5505505555"));
                repoCliente.save(new Cliente("1000001018", "Rafael Ortega", "rafaelortega@yahoo.com", "5605605656"));
                repoCliente.save(new Cliente("1000001019", "Adriana Pardo", "adrianapardo@hotmail.com", "5705705757"));
                repoCliente.save(new Cliente("1000001020", "Gabriel Silva", "gabrielsilva@gmail.com", "5805805858"));
                repoCliente.save(
                                new Cliente("1000001021", "Valentina Rojas", "valentinarojas@yahoo.com", "5905905959"));
                repoCliente.save(
                                new Cliente("1000001022", "Hector Ramirez", "hectorramirez@hotmail.com", "6006006060"));
                repoCliente.save(new Cliente("1000001023", "Carolina Lopez", "carolinalopez@gmail.com", "6106106161"));
                repoCliente.save(new Cliente("1000001024", "Daniel Perez", "danielperez@yahoo.com", "6206206262"));
                repoCliente.save(new Cliente("1000001025", "Camila Torres", "camilatorres@hotmail.com", "6306306363"));
                repoCliente.save(new Cliente("1000001026", "Sebastian Medina", "sebastianmedina@gmail.com",
                                "6406406464"));
                repoCliente.save(new Cliente("1000001027", "Natalia Ortiz", "nataliaortiz@yahoo.com", "6506506565"));
                repoCliente.save(new Cliente("1000001028", "Andres Gonzalez", "andresgonzalez@hotmail.com",
                                "6606606666"));

                // MASCOTAS
                repoMascota.save(new Mascota("Iris", "Husky", 3, 20000,
                                "https://t2.uc.ltmcdn.com/es/posts/4/6/5/como_saber_si_mi_husky_es_puro_50564_600.jpg"));
                repoMascota.save(new Mascota("Max", "Samoyero", 5, 40000,
                                "https://images.hola.com/imagenes/mascotas/20200811173399/-de-perro-grandes-samoyedo/0-854-717/samoyedo-m.jpg?tx=w_680"));
                repoMascota.save(new Mascota("Yogui", "Golden", 4, 30000,
                                "https://www.hepper.com/wp-content/uploads/2021/11/golden-retriever_Shutterstock.jpg"));
                repoMascota.save(new Mascota("Max", "Labrador", 5, 2500,
                                "https://www.webconsultas.com/sites/default/files/styles/wch_image_schema/public/temas/caracteristicas-perro-labrador.jpg"));
                repoMascota.save(new Mascota("Luna", "Retriever", 2, 2200,
                                "https://t2.ea.ltmcdn.com/es/posts/1/6/2/10_curiosidades_del_golden_retriever_21261_orig.jpg"));
                repoMascota.save(new Mascota("Rocky", "Bulldog", 4, 2800,
                                "https://www.zooplus.es/magazine/wp-content/uploads/2017/10/fotolia_58776564-768x491.jpg"));
                repoMascota.save(new Mascota("Bella", "Poodle", 1, 1800,
                                "https://heraldodemexico.com.mx/wp-content/uploads/2020/06/caniche-1-1-1200x829.jpg"));
                repoMascota.save(new Mascota("Charlie", "Boxer", 6, 3000,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6f/Male_fawn_Boxer_undocked.jpg/1200px-Male_fawn_Boxer_undocked.jpg"));
                repoMascota.save(new Mascota("Lucy", "Pug", 2, 1500,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/My_pug.jpg/640px-My_pug.jpg"));
                repoMascota.save(new Mascota("Cooper", "Husky", 3, 2200,
                                "https://t2.uc.ltmcdn.com/es/posts/4/6/5/como_saber_si_mi_husky_es_puro_50564_600.jpg"));
                repoMascota.save(new Mascota("Daisy", "Beagle", 4, 2100,
                                "https://biodog.es/wp-content/uploads/2018/12/Beagle-cachorro_razas-de-perro.jpg"));
                repoMascota.save(new Mascota("Bailey", "Rottweiler", 5, 2700,
                                "https://es.mypet.com/wp-content/uploads/sites/23/2021/03/rottweiler-no-lo-dejes-al-azar-scaled-1.jpg"));
                repoMascota.save(new Mascota("Buddy", "Dachshund", 2, 1600,
                                "https://www.thesprucepets.com/thmb/8UgAnzf_7o7i7qPPr528XtM0IW8=/2121x0/filters:no_upscale():strip_icc()/GettyImages-839279536-313d30c290584bc0a207bc6243263bd4.jpg"));
                repoMascota.save(new Mascota("Molly", "Shih Tzu", 3, 1900,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/30/Shih-Tzu.JPG/320px-Shih-Tzu.JPG"));
                repoMascota.save(new Mascota("Sadie", "Great Dane", 4, 2900,
                                "https://www.zooplus.es/magazine/wp-content/uploads/2017/10/deutsche-dogge.jpg"));
                repoMascota.save(new Mascota("Toby", "Corgi", 2, 1700,
                                "https://thumbor.forbes.com/thumbor/fit-in/900x510/https://www.forbes.com/advisor/wp-content/uploads/2023/11/how-long-do-corgis-live.jpeg.jpg"));
                repoMascota.save(new Mascota("Jack", "Doberman", 6, 3100,
                                "https://www.zooplus.es/magazine/wp-content/uploads/2017/10/Doberman.jpg"));
                repoMascota.save(new Mascota("Sophie", "Chihuahua", 1, 1400,
                                "https://t1.uc.ltmcdn.com/es/posts/8/7/8/cuanto_mide_un_perro_chihuahua_29878_600.jpg"));
                repoMascota.save(new Mascota("Bear", "Maltese", 3, 2000,
                                "https://www.vidavetcare.com/wp-content/uploads/sites/234/2022/04/maltese-dog-breed-info.jpeg"));
                repoMascota.save(new Mascota("Milo", "Collie", 4, 2300,
                                "https://upload.wikimedia.org/wikipedia/commons/6/6c/1Dog-rough-collie-portrait.jpg"));
                repoMascota.save(new Mascota("Lola", "Shepherd", 2, 2100,
                                "https://www.zooplus.es/magazine/wp-content/uploads/2017/10/deutsche-dogge.jpg"));
                repoMascota.save(new Mascota("Harley", "Bernese", 5, 2800,
                                "https://www.thesprucepets.com/thmb/8UgAnzf_7o7i7qPPr528XtM0IW8=/2121x0/filters:no_upscale():strip_icc()/GettyImages-839279536-313d30c290584bc0a207bc6243263bd4.jpg"));
                repoMascota.save(new Mascota("Coco", "Spaniel", 3, 1900,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/30/Shih-Tzu.JPG/320px-Shih-Tzu.JPG"));
                repoMascota.save(new Mascota("Bear", "Saint", 4, 3000,
                                "https://www.vidavetcare.com/wp-content/uploads/sites/234/2022/04/maltese-dog-breed-info.jpeg"));
                repoMascota.save(new Mascota("Bailey", "Mastiff", 6, 3200,
                                "https://es.mypet.com/wp-content/uploads/sites/23/2021/03/rottweiler-no-lo-dejes-al-azar-scaled-1.jpg"));
                repoMascota.save(new Mascota("Gizmo", "Dalmatian", 2, 1700,
                                "https://biodog.es/wp-content/uploads/2018/12/Beagle-cachorro_razas-de-perro.jpg"));
                repoMascota.save(new Mascota("Maggie", "Schnauzer", 3, 1800,
                                "https://thumbor.forbes.com/thumbor/fit-in/900x510/https://www.forbes.com/advisor/wp-content/uploads/2023/11/how-long-do-corgis-live.jpeg.jpg"));
                repoMascota.save(new Mascota("Duke", "Hound", 5, 2600,
                                "https://t2.uc.ltmcdn.com/es/posts/4/6/5/como_saber_si_mi_husky_es_puro_50564_600.jpg"));
                repoMascota.save(new Mascota("Zoey", "Inu", 2, 1600,
                                "https://www.thesprucepets.com/thmb/8UgAnzf_7o7i7qPPr528XtM0IW8=/2121x0/filters:no_upscale():strip_icc()/GettyImages-839279536-313d30c290584bc0a207bc6243263bd4.jpg"));
                repoMascota.save(new Mascota("Riley", "Samoyed", 4, 2400,
                                "https://www.zooplus.es/magazine/wp-content/uploads/2017/10/Doberman.jpg"));
                repoMascota.save(new Mascota("Lucky", "Malamute", 3, 2200,
                                "https://upload.wikimedia.org/wikipedia/commons/6/6c/1Dog-rough-collie-portrait.jpg"));
                repoMascota.save(new Mascota("Rosie", "Pomeranian", 2, 1500,
                                "https://t1.uc.ltmcdn.com/es/posts/8/7/8/cuanto_mide_un_perro_chihuahua_29878_600.jpg"));
                repoMascota.save(new Mascota("Sam", "Pitbull", 4, 2700,
                                "https://biodog.es/wp-content/uploads/2018/12/Beagle-cachorro_razas-de-perro.jpg"));
                repoMascota.save(new Mascota("Ollie", "Frise", 3, 1900,
                                "https://thumbor.forbes.com/thumbor/fit-in/900x510/https://www.forbes.com/advisor/wp-content/uploads/2023/11/how-long-do-corgis-live.jpeg.jpg"));
                repoMascota.save(new Mascota("Rusty", "Wolfhound", 5, 3000,
                                "https://t2.uc.ltmcdn.com/es/posts/4/6/5/como_saber_si_mi_husky_es_puro_50564_600.jpg"));
                repoMascota.save(new Mascota("Penny", "Pinscher", 2, 1600,
                                "https://www.thesprucepets.com/thmb/8UgAnzf_7o7i7qPPr528XtM0IW8=/2121x0/filters:no_upscale():strip_icc()/GettyImages-839279536-313d30c290584bc0a207bc6243263bd4.jpg"));
                repoMascota.save(new Mascota("Loki", "Akita", 4, 2500,
                                "https://www.vidavetcare.com/wp-content/uploads/sites/234/2022/04/maltese-dog-breed-info.jpeg"));
                repoMascota.save(new Mascota("Charlie", "Bloodhound", 3, 2100,
                                "https://upload.wikimedia.org/wikipedia/commons/6/6c/1Dog-rough-collie-portrait.jpg"));
                repoMascota.save(new Mascota("Simba", "Weimaraner", 2, 1700,
                                "https://www.thesprucepets.com/thmb/8UgAnzf_7o7i7qPPr528XtM0IW8=/2121x0/filters:no_upscale():strip_icc()/GettyImages-839279536-313d30c290584bc0a207bc6243263bd4.jpg"));
                repoMascota.save(new Mascota("Zeus", "Chow", 5, 2800,
                                "https://t1.uc.ltmcdn.com/es/posts/8/7/8/cuanto_mide_un_perro_chihuahua_29878_600.jpg"));
                repoMascota.save(new Mascota("Mia", "Bulldog", 3, 2000,
                                "https://upload.wikimedia.org/wikipedia/commons/6/6c/1Dog-rough-collie-portrait.jpg"));
                repoMascota.save(new Mascota("Murphy", "Pekingese", 4, 2200,
                                "https://biodog.es/wp-content/uploads/2018/12/Beagle-cachorro_razas-de-perro.jpg"));
                repoMascota.save(new Mascota("Luna", "Borzoi", 2, 1800,
                                "https://thumbor.forbes.com/thumbor/fit-in/900x510/https://www.forbes.com/advisor/wp-content/uploads/2023/11/how-long-do-corgis-live.jpeg.jpg"));
                repoMascota.save(new Mascota("Harper", "Basenji", 3, 1900,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/30/Shih-Tzu.JPG/320px-Shih-Tzu.JPG"));
                repoMascota.save(new Mascota("Max", "Labrador", 6, 3000,
                                "https://www.webconsultas.com/sites/default/files/styles/wch_image_schema/public/temas/caracteristicas-perro-labrador.jpg"));
                repoMascota.save(new Mascota("Bella", "Golden Retriever", 4, 2500,
                                "https://t2.ea.ltmcdn.com/es/posts/1/6/2/10_curiosidades_del_golden_retriever_21261_orig.jpg"));
                repoMascota.save(new Mascota("Rocky", "German Shepherd", 5, 2800,
                                "https://www.zooplus.es/magazine/wp-content/uploads/2017/10/deutsche-dogge.jpg"));
                repoMascota.save(new Mascota("Daisy", "Beagle", 2, 1800,
                                "https://biodog.es/wp-content/uploads/2018/12/Beagle-cachorro_razas-de-perro.jpg"));
                repoMascota.save(new Mascota("Charlie", "Poodle", 4, 2200,
                                "https://heraldodemexico.com.mx/wp-content/uploads/2020/06/caniche-1-1-1200x829.jpg"));
                repoMascota.save(new Mascota("Lucy", "Shih Tzu", 3, 2000,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/30/Shih-Tzu.JPG/320px-Shih-Tzu.JPG"));
                repoMascota.save(new Mascota("Cooper", "Boxer", 5, 2600,
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6f/Male_fawn_Boxer_undocked.jpg/1200px-Male_fawn_Boxer_undocked.jpg"));
                repoMascota.save(new Mascota("Lola", "Dachshund", 3, 1900,
                                "https://www.thesprucepets.com/thmb/8UgAnzf_7o7i7qPPr528XtM0IW8=/2121x0/filters:no_upscale():strip_icc()/GettyImages-839279536-313d30c290584bc0a207bc6243263bd4.jpg"));
                repoMascota.save(new Mascota("Bailey", "Siberian Husky", 4, 2300,
                                "https://t2.uc.ltmcdn.com/es/posts/4/6/5/como_saber_si_mi_husky_es_puro_50564_600.jpg"));
                repoMascota.save(new Mascota("Buddy", "Great Dane", 2, 2000,
                                "https://www.zooplus.es/magazine/wp-content/uploads/2017/10/deutsche-dogge.jpg"));
                repoMascota.save(new Mascota("Sadie", "Rottweiler", 4, 2400,
                                "https://es.mypet.com/wp-content/uploads/sites/23/2021/03/rottweiler-no-lo-dejes-al-azar-scaled-1.jpg"));
                repoMascota.save(new Mascota("Milo", "Doberman Pinscher", 3, 2100,
                                "https://www.zooplus.es/magazine/wp-content/uploads/2017/10/Doberman.jpg"));
                repoMascota.save(new Mascota("Sophie", "Cavalier", 2, 1900,
                                "https://www.vidavetcare.com/wp-content/uploads/sites/234/2022/04/maltese-dog-breed-info.jpeg"));
                repoMascota.save(new Mascota("Toby", "Yorkshire Terrier", 5, 2500,
                                "https://www.webconsultas.com/sites/default/files/styles/wch_image_schema/public/temas/caracteristicas-perro-labrador.jpg"));
                repoMascota.save(new Mascota("Chloe", "Pomeranian", 2, 1900,
                                "https://www.purina.es/sites/default/files/styles/square_medium_440x440/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-09Pomeranian.jpg?itok=DXKBe758"));
                repoMascota.save(new Mascota("Rusty", "Pug", 4, 2500,
                                "https://cloudfront-us-east-1.images.arcpublishing.com/elespectador/JHLWPZQCQNCJRIYVCLNUKIISU4.jpg"));
                repoMascota.save(new Mascota("Tucker", "Dachshund", 3, 2300,
                                "https://www.elmueble.com/medio/2023/03/02/perro-de-raza-beagle_67c65dda_230302133955_1200x630.jpg"));
                repoMascota.save(new Mascota("Harley", "Siberian Husky", 5, 2700,
                                "https://t1.uc.ltmcdn.com/es/posts/4/6/5/como_saber_si_mi_husky_es_puro_50564_orig.jpg"));
                repoMascota.save(new Mascota("Luna", "Bulldog", 2, 2000,
                                "https://cloudfront-us-east-1.images.arcpublishing.com/elespectador/JHLWPZQCQNCJRIYVCLNUKIISU4.jpg"));
                repoMascota.save(new Mascota("Oliver", "French Bulldog", 4, 2400,
                                "https://cloudfront-us-east-1.images.arcpublishing.com/elespectador/JHLWPZQCQNCJRIYVCLNUKIISU4.jpg"));
                repoMascota.save(new Mascota("Daisy", "Poodle", 3, 2200,
                                "https://www.nationalgeographic.com.es/medio/2023/05/31/un-perro-de-la-raza-labrador-retriever_00000000_d0938095_230531120054_800x800.jpg"));
                repoMascota.save(new Mascota("Milo", "Doberman Pinscher", 5, 2800,
                                "https://hips.hearstapps.com/hmg-prod/images/gettyimages-695480884-64f8446a4e85d.jpg")); // Aleatoria
                repoMascota.save(new Mascota("Lola", "Shiba Inu", 2, 1900,
                                "https://hips.hearstapps.com/hmg-prod/images/gettyimages-695480884-64f8446a4e85d.jpg")); // Aleatoria
                repoMascota.save(new Mascota("Bailey", "Great Dane", 4, 2500,
                                "https://hips.hearstapps.com/hmg-prod/images/gettyimages-695480884-64f8446a4e85d.jpg")); // Aleatoria
                repoMascota.save(new Mascota("Jack", "Labrador Retriever", 3, 2300,
                                "https://www.nationalgeographic.com.es/medio/2023/05/31/un-perro-de-la-raza-labrador-retriever_00000000_d0938095_230531120054_800x800.jpg"));
                repoMascota.save(new Mascota("Lucy", "Golden Retriever", 5, 2700,
                                "https://www.nationalgeographic.com.es/medio/2023/05/31/un-perro-de-la-raza-labrador-retriever_00000000_d0938095_230531120054_800x800.jpg"));
                repoMascota.save(new Mascota("Bear", "Beagle", 2, 2000,
                                "https://www.elmueble.com/medio/2023/03/02/perro-de-raza-beagle_67c65dda_230302133955_1200x630.jpg"));
                repoMascota.save(new Mascota("Coco", "Pomeranian", 4, 2400,
                                "https://www.purina.es/sites/default/files/styles/square_medium_440x440/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-09Pomeranian.jpg?itok=DXKBe758"));
                repoMascota.save(new Mascota("Bailey", "Pug", 3, 2200,
                                "https://cloudfront-us-east-1.images.arcpublishing.com/elespectador/JHLWPZQCQNCJRIYVCLNUKIISU4.jpg"));
                repoMascota.save(new Mascota("Sasha", "Dachshund", 5, 2800,
                                "https://www.elmueble.com/medio/2023/03/02/perro-de-raza-beagle_67c65dda_230302133955_1200x630.jpg"));
                repoMascota.save(new Mascota("Rocky", "Siberian Husky", 2, 1900,
                                "https://t1.uc.ltmcdn.com/es/posts/4/6/5/como_saber_si_mi_husky_es_puro_50564_orig.jpg"));
                repoMascota.save(new Mascota("Zoey", "Bulldog", 4, 2500,
                                "https://cloudfront-us-east-1.images.arcpublishing.com/elespectador/JHLWPZQCQNCJRIYVCLNUKIISU4.jpg"));
                repoMascota.save(new Mascota("Buddy", "French Bulldog", 3, 2300,
                                "https://cloudfront-us-east-1.images.arcpublishing.com/elespectador/JHLWPZQCQNCJRIYVCLNUKIISU4.jpg"));
                repoMascota.save(new Mascota("Luna", "Poodle", 5, 2700,
                                "https://www.nationalgeographic.com.es/medio/2023/05/31/un-perro-de-la-raza-labrador-retriever_00000000_d0938095_230531120054_800x800.jpg"));
                repoMascota.save(new Mascota("Cooper", "Doberman Pinscher", 2, 2000,
                                "https://hips.hearstapps.com/hmg-prod/images/gettyimages-695480884-64f8446a4e85d.jpg")); // Aleatoria
                repoMascota.save(new Mascota("Sadie", "Shiba Inu", 4, 2400,
                                "https://hips.hearstapps.com/hmg-prod/images/gettyimages-695480884-64f8446a4e85d.jpg")); // Aleatoria
                repoMascota.save(new Mascota("Charlie", "Great Dane", 3, 2200,
                                "https://hips.hearstapps.com/hmg-prod/images/gettyimages-695480884-64f8446a4e85d.jpg")); // Aleatoria
                repoMascota.save(new Mascota("Bella", "Labrador Retriever", 5, 2800,
                                "https://www.nationalgeographic.com.es/medio/2023/05/31/un-perro-de-la-raza-labrador-retriever_00000000_d0938095_230531120054_800x800.jpg"));
                repoMascota.save(new Mascota("Max", "Golden Retriever", 2, 1900,
                                "https://www.nationalgeographic.com.es/medio/2023/05/31/un-perro-de-la-raza-labrador-retriever_00000000_d0938095_230531120054_800x800.jpg"));
                repoMascota.save(new Mascota("Ruby", "Beagle", 4, 2500,
                                "https://www.elmueble.com/medio/2023/03/02/perro-de-raza-beagle_67c65dda_230302133955_1200x630.jpg"));
                repoMascota.save(new Mascota("Bailey", "Pomeranian", 3, 2300,
                                "https://www.purina.es/sites/default/files/styles/square_medium_440x440/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-09Pomeranian.jpg?itok=DXKBe758"));
                repoMascota.save(new Mascota("Buddy", "Pug", 5, 2700,
                                "https://cloudfront-us-east-1.images.arcpublishing.com/elespectador/JHLWPZQCQNCJRIYVCLNUKIISU4.jpg"));
                repoMascota.save(new Mascota("Molly", "Dachshund", 2, 2000,
                                "https://www.elmueble.com/medio/2023/03/02/perro-de-raza-beagle_67c65dda_230302133955_1200x630.jpg"));
                repoMascota.save(new Mascota("Bailey", "Siberian Husky", 4, 2400,
                                "https://t1.uc.ltmcdn.com/es/posts/4/6/5/como_saber_si_mi_husky_es_puro_50564_orig.jpg"));
                repoMascota.save(new Mascota("Lola", "Bulldog", 3, 2200,
                                "https://cloudfront-us-east-1.images.arcpublishing.com/elespectador/JHLWPZQCQNCJRIYVCLNUKIISU4.jpg"));
                repoMascota.save(new Mascota("Bailey", "French Bulldog", 5, 2800,
                                "https://cloudfront-us-east-1.images.arcpublishing.com/elespectador/JHLWPZQCQNCJRIYVCLNUKIISU4.jpg"));
                repoMascota.save(new Mascota("Rocky", "Poodle", 2, 1900,
                                "https://www.nationalgeographic.com.es/medio/2023/05/31/un-perro-de-la-raza-labrador-retriever_00000000_d0938095_230531120054_800x800.jpg"));
                repoMascota.save(new Mascota("Daisy", "Doberman", 4, 2500,
                                "https://hips.hearstapps.com/hmg-prod/images/gettyimages-695480884-64f8446a4e85d.jpg")); // Aleatoria
                repoMascota.save(new Mascota("Lucy", "Shiba Inu", 3, 2300,
                                "https://hips.hearstapps.com/hmg-prod/images/gettyimages-695480884-64f8446a4e85d.jpg")); // Aleatoria
                repoMascota.save(new Mascota("Max", "Great Dane", 5, 2700,
                                "https://hips.hearstapps.com/hmg-prod/images/gettyimages-695480884-64f8446a4e85d.jpg")); // Aleatoria
                repoMascota.save(new Mascota("Milo", "Labrador Retriever", 2, 2000,
                                "https://www.nationalgeographic.com.es/medio/2023/05/31/un-perro-de-la-raza-labrador-retriever_00000000_d0938095_230531120054_800x800.jpg"));
                repoMascota.save(new Mascota("Sophie", "Golden Retriever", 4, 2400,
                                "https://www.nationalgeographic.com.es/medio/2023/05/31/un-perro-de-la-raza-labrador-retriever_00000000_d0938095_230531120054_800x800.jpg"));
                repoMascota.save(new Mascota("Bailey", "Beagle", 3, 2200,
                                "https://www.elmueble.com/medio/2023/03/02/perro-de-raza-beagle_67c65dda_230302133955_1200x630.jpg"));
                repoMascota.save(new Mascota("Cooper", "Pomeranian", 5, 2800,
                                "https://www.purina.es/sites/default/files/styles/square_medium_440x440/public/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-09Pomeranian.jpg?itok=DXKBe758"));
                repoMascota.save(new Mascota("Sadie", "Pug", 2, 1900,
                                "https://cloudfront-us-east-1.images.arcpublishing.com/elespectador/JHLWPZQCQNCJRIYVCLNUKIISU4.jpg"));
                repoMascota.save(new Mascota("Shadow", "Dachshund", 4, 2500,
                                "https://www.elmueble.com/medio/2023/03/02/perro-de-raza-beagle_67c65dda_230302133955_1200x630.jpg"));

                repoVeterinario.save(new Veterinario("12345678", "Sebastián Angarita", "password",
                                "https://images.ctfassets.net/pdf29us7flmy/69sCM6f2F5THBeBnNewynl/8ed3116aaf346a441d214b9f92748e21/-IND-001-036-_Types_of_Veterinary_Careers_Final.png?w=720&q=100&fm=jpg"));
                repoVeterinario.save(new Veterinario("87654321", "Juan Zuluaga", "password",
                                "https://images.ctfassets.net/pdf29us7flmy/69sCM6f2F5THBeBnNewynl/8ed3116aaf346a441d214b9f92748e21/-IND-001-036-_Types_of_Veterinary_Careers_Final.png?w=720&q=100&fm=jpg"));
                repoVeterinario.save(new Veterinario("11223344", "Carlos Parra", "password",
                                "https://images.ctfassets.net/pdf29us7flmy/69sCM6f2F5THBeBnNewynl/8ed3116aaf346a441d214b9f92748e21/-IND-001-036-_Types_of_Veterinary_Careers_Final.png?w=720&q=100&fm=jpg"));
                repoVeterinario.save(new Veterinario("55667788", "Jose Hurtado", "password",
                                "https://images.ctfassets.net/pdf29us7flmy/69sCM6f2F5THBeBnNewynl/8ed3116aaf346a441d214b9f92748e21/-IND-001-036-_Types_of_Veterinary_Careers_Final.png?w=720&q=100&fm=jpg"));
                repoVeterinario.save(new Veterinario("18273645", "Andrea Rueda", "password",
                                "https://images.ctfassets.net/pdf29us7flmy/69sCM6f2F5THBeBnNewynl/8ed3116aaf346a441d214b9f92748e21/-IND-001-036-_Types_of_Veterinary_Careers_Final.png?w=720&q=100&fm=jpg"));

                repoEspecialidad.save(new Especialidad("General"));
                repoEspecialidad.save(new Especialidad("Cardiologia"));
                repoEspecialidad.save(new Especialidad("Dermatologia"));
                repoEspecialidad.save(new Especialidad("Gastroenterologia"));
                repoEspecialidad.save(new Especialidad("Ortopedia"));

                repoEstadoVet.save(new EstadoVet("Activo"));
                repoEstadoVet.save(new EstadoVet("Inactivo"));
                repoEstadoVet.save(new EstadoVet("Vacaciones"));

                Veterinario asociarVet = repoVeterinario.findById(1L).get();
                asociarVet.setEspecialidad(repoEspecialidad.findById(1L).get());
                asociarVet.setEstado(repoEstadoVet.findByNombre("Activo"));
                repoVeterinario.save(asociarVet);
                asociarVet = repoVeterinario.findById(2L).get();
                asociarVet.setEspecialidad(repoEspecialidad.findById(2L).get());
                asociarVet.setEstado(repoEstadoVet.findByNombre("Activo"));
                repoVeterinario.save(asociarVet);
                asociarVet = repoVeterinario.findById(3L).get();
                asociarVet.setEspecialidad(repoEspecialidad.findById(3L).get());
                asociarVet.setEstado(repoEstadoVet.findByNombre("Inactivo"));
                repoVeterinario.save(asociarVet);
                asociarVet = repoVeterinario.findById(4L).get();
                asociarVet.setEspecialidad(repoEspecialidad.findById(4L).get());
                asociarVet.setEstado(repoEstadoVet.findByNombre("Activo"));
                repoVeterinario.save(asociarVet);
                asociarVet = repoVeterinario.findById(5L).get();
                asociarVet.setEspecialidad(repoEspecialidad.findById(5L).get());
                asociarVet.setEstado(repoEstadoVet.findByNombre("Vacaciones"));
                repoVeterinario.save(asociarVet);

                repoEstadoMas.save(new EstadoMas("Ingresado"));
                repoEstadoMas.save(new EstadoMas("De baja"));

                Mascota asociar = repoMascota.findById(1L).get();
                asociar.setDueno(repoCliente.findById(2L).get());
                asociar.setEstado(repoEstadoMas.findById(2L).get());
                repoMascota.save(asociar);
                asociar = repoMascota.findById(2L).get();
                asociar.setDueno(repoCliente.findById(2L).get());
                asociar.setEstado(repoEstadoMas.findById(2L).get());
                repoMascota.save(asociar);
                asociar = repoMascota.findById(3L).get();
                asociar.setDueno(repoCliente.findById(1L).get());
                asociar.setEstado(repoEstadoMas.findById(2L).get());
                repoMascota.save(asociar);

                Long contadorCliente = 1L;
                Long totalClientes = repoCliente.count(); // Obtener la cantidad total de clientes

                for (Long i = 1L; i <= 100L; i++) {
                        Mascota asociar1 = repoMascota.findById(i).orElse(null);

                        if (asociar1 != null) {
                                Cliente cliente = repoCliente.findById(contadorCliente).orElse(null);

                                if (cliente != null) {
                                        asociar1.setDueno(cliente);
                                        asociar1.setEstado(repoEstadoMas.findById(2L).orElse(null));

                                        repoMascota.save(asociar1);

                                        if (i % 2 == 0) {
                                                contadorCliente = (contadorCliente % totalClientes) + 1L;

                                        }
                                }
                        }
                }

                for (Long i = 1L; i <= 10L; i++) {
                        Cliente asociarCliente = repoCliente.findById(i).orElse(null);

                        if (asociarCliente != null) {
                                asociarCliente.setVeterinario(repoVeterinario.findById(1L).orElse(null));

                                repoCliente.save(asociarCliente);
                        }
                }

                for (Long i = 11L; i <= 20L; i++) {
                        Cliente asociarCliente = repoCliente.findById(i).orElse(null);

                        if (asociarCliente != null) {
                                asociarCliente.setVeterinario(repoVeterinario.findById(2L).orElse(null));

                                repoCliente.save(asociarCliente);
                        }
                }

                for (Long i = 21L; i <= 30L; i++) {
                        Cliente asociarCliente = repoCliente.findById(i).orElse(null);

                        if (asociarCliente != null) {
                                asociarCliente.setVeterinario(repoVeterinario.findById(3L).orElse(null));

                                repoCliente.save(asociarCliente);
                        }
                }

                for (Long i = 31L; i <= 40L; i++) {
                        Cliente asociarCliente = repoCliente.findById(i).orElse(null);

                        if (asociarCliente != null) {
                                asociarCliente.setVeterinario(repoVeterinario.findById(4L).orElse(null));

                                repoCliente.save(asociarCliente);
                        }
                }

                for (Long i = 41L; i <= 50L; i++) {
                        Cliente asociarCliente = repoCliente.findById(i).orElse(null);

                        if (asociarCliente != null) {
                                asociarCliente.setVeterinario(repoVeterinario.findById(5L).orElse(null));

                                repoCliente.save(asociarCliente);
                        }
                }

                // Añadir prioridades de enfermedad
                Prioridad prioridad1 = new Prioridad("Baja");
                Prioridad prioridad2 = new Prioridad("Media");
                Prioridad prioridad3 = new Prioridad("Alta");

                repoPrioridad.save(prioridad1);
                repoPrioridad.save(prioridad2);
                repoPrioridad.save(prioridad3);

                // Añadir enfermedades
                Enfermedad enfermedad = new Enfermedad("Parásitos");
                enfermedad.setPrioridad(repoPrioridad.findById(1L).orElse(null));
                repoEnfermedad.save(enfermedad);
                Enfermedad enfermedad1 = new Enfermedad("Diarrea");
                enfermedad1.setPrioridad(repoPrioridad.findById(2L).orElse(null));
                repoEnfermedad.save(enfermedad1);
                Enfermedad enfermedad2 = new Enfermedad("Asma");
                enfermedad2.setPrioridad(repoPrioridad.findById(3L).orElse(null));
                repoEnfermedad.save(enfermedad2);
                Enfermedad enfermedad3 = new Enfermedad("Dermatitis");
                enfermedad3.setPrioridad(repoPrioridad.findById(1L).orElse(null));
                repoEnfermedad.save(enfermedad3);
                Enfermedad enfermedad4 = new Enfermedad("Insuficiencia renal");
                enfermedad4.setPrioridad(repoPrioridad.findById(2L).orElse(null));
                repoEnfermedad.save(enfermedad4);
                Enfermedad enfermedad5 = new Enfermedad("Hipertensión");
                enfermedad5.setPrioridad(repoPrioridad.findById(3L).orElse(null));
                repoEnfermedad.save(enfermedad5);
                Enfermedad enfermedad6 = new Enfermedad("Epilepsia");
                enfermedad6.setPrioridad(repoPrioridad.findById(1L).orElse(null));
                repoEnfermedad.save(enfermedad6);
                Enfermedad enfermedad7 = new Enfermedad("Gingivitis");
                enfermedad7.setPrioridad(repoPrioridad.findById(2L).orElse(null));
                repoEnfermedad.save(enfermedad7);
                Enfermedad enfermedad8 = new Enfermedad("Epilepsia");
                enfermedad8.setPrioridad(repoPrioridad.findById(3L).orElse(null));
                repoEnfermedad.save(enfermedad8);
                Enfermedad enfermedad9 = new Enfermedad("Sarro");
                enfermedad9.setPrioridad(repoPrioridad.findById(1L).orElse(null));
                repoEnfermedad.save(enfermedad9);
                Enfermedad enfermedad10 = new Enfermedad("Vómito");
                enfermedad10.setPrioridad(repoPrioridad.findById(2L).orElse(null));
                repoEnfermedad.save(enfermedad10);

                // Cargar medicamentos desde un excel
                try (BufferedReader br = new BufferedReader(new FileReader(
                                "./demo/src/main/resources/static/MEDICAMENTOS_VETERINARIA.csv"))) {
                        String line = br.readLine();
                        line = br.readLine();

                        while ((line = br.readLine()) != null) {
                                Medicamento medicamento = new Medicamento();
                                String[] values = line.split(";");
                                medicamento.setNombre(values[0]);
                                medicamento.setPrecio(Float.parseFloat(values[1].substring(1)));
                                medicamento.setCosto(Float.parseFloat(values[2].substring(1)));
                                medicamento.setUnidades(Integer.parseInt(values[3]));
                                medicamento.setVendidas(Integer.parseInt(values[4]));
                                int randomNumber = (int) (Math.random() * 11);
                                switch (randomNumber) {
                                        case 0:
                                                medicamento.setEnfermedad(enfermedad);
                                                break;

                                        case 1:
                                                medicamento.setEnfermedad(enfermedad1);
                                                break;

                                        case 2:
                                                medicamento.setEnfermedad(enfermedad2);
                                                break;

                                        case 3:
                                                medicamento.setEnfermedad(enfermedad3);
                                                break;

                                        case 4:
                                                medicamento.setEnfermedad(enfermedad4);
                                                break;

                                        case 5:
                                                medicamento.setEnfermedad(enfermedad5);
                                                break;

                                        case 6:
                                                medicamento.setEnfermedad(enfermedad6);
                                                break;

                                        case 7:
                                                medicamento.setEnfermedad(enfermedad7);
                                                break;

                                        case 8:
                                                medicamento.setEnfermedad(enfermedad8);
                                                break;

                                        case 9:
                                                medicamento.setEnfermedad(enfermedad9);
                                                break;

                                        default:
                                                medicamento.setEnfermedad(enfermedad10);
                                                break;
                                }

                                repoMedicamento.save(medicamento);
                        }
                }

                // Crear Tratamientos en la BD
                for (int i = 0; i < 100; i++) {
                        LocalDate startDate = LocalDate.of(2024, 1, 1);
                        LocalDate endDate = LocalDate.of(2024, 6, 21);

                        long randomDays = new Random().nextLong(ChronoUnit.DAYS.between(startDate, endDate));

                        LocalDate randomDate = startDate.plusDays(randomDays);

                        long randomDays2 = new Random().nextLong(ChronoUnit.DAYS.between(randomDate, endDate));

                        LocalDate randomDate2 = startDate.plusDays(randomDays2);

                        Date dateInicio = new java.sql.Date(
                                        randomDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
                        Date dateFinal = new java.sql.Date(
                                        randomDate2.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());

                        Tratamiento tratamiento = new Tratamiento();
                        tratamiento.setFechaInicio(dateInicio);
                        tratamiento.setFechaFin(dateFinal);
                        Mascota mascota = repoMascota.findById((long) i + 1).get();
                        mascota.setEstado(repoEstadoMas.findByNombre("Ingresado"));
                        tratamiento.setMascota(mascota);
                        Long medicamentoId = (long) i*3 + 1;
                        Medicamento medicamento = repoMedicamento.findById(medicamentoId).get();
                        tratamiento.setMedicamento(medicamento);
                        tratamiento.setCosto((float) medicamento.getPrecio());
                        if (Math.random() > 0.2) {
                                tratamiento.setMedicamentoAplicado(false);
                        }
                        else {
                                tratamiento.setMedicamentoAplicado(true);
                        }
                        repoTratamiento.save(tratamiento);
                }

        }

}