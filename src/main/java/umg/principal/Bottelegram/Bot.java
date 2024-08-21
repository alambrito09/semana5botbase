package umg.principal.Bottelegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

    public class Bot extends TelegramLongPollingBot {
        private static final double EURO_TO_QUETZAL_RATE = 8.5;
        private static final long[] CHAT_IDS = {6108736830L, 6082604734L, 2085251453L,1503995250
                ,1534824490,6421826691L};
        @Override
        public String getBotUsername() {
            return "Mamao123456bot";
        }

        @Override
        public String getBotToken() {
            return "6862999139:AAFRLE2FFQoizDi6_gHK1KrhM4WDYd9BXR4";
        }

        @Override
        public void onUpdateReceived(Update update) {

            // Asegurarse de que el mensaje existe y tiene texto.
            if (update.hasMessage() && update.getMessage().hasText()) {
                String nombre = update.getMessage().getFrom().getFirstName();
                String apellido = update.getMessage().getFrom().getLastName(); // Cambié a obtener el apellido
                String nickname = update.getMessage().getFrom().getUserName(); // Cambié a obtener el username
                LocalDateTime fecha = LocalDateTime.now();
                DateTimeFormatter hora = DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'a las' HH:mm");
                String message_text = update.getMessage().getText();
                long chat_id = update.getMessage().getChatId();
                if (message_text.toLowerCase().equals("/start")) {
                    sendText(chat_id, "hola " + nombre + ", ¿cómo estás? ingresa un comando");
                    sendText(chat_id, " para ver la lista de comando ingresa /lista");
                    System.out.println("Hola " + nickname + nombre + ", tu nombre es: " + nombre + " y tu apellido es: " + apellido);
                    System.out.println("Enviaste: " + message_text);
                }

                if (message_text.toLowerCase().equals("hola")) {
                    sendText(chat_id, "hola " + nombre + ", ¿cómo estás? ingresa un comando");
                    sendText(chat_id, " para ver la lista de comando ingresa /lista");
                    System.out.println("Hola " + nickname + nombre + ", tu nombre es: " + nombre + " y tu apellido es: " + apellido);
                    System.out.println("Enviaste: " + message_text);
                }
                // Responder al mensaje "hola" o "bye"
                if (message_text.toLowerCase().equals("/lista")) {
                    System.out.println("El chat_id del usuario es: " + chat_id);
                    sendText(chat_id, "lista de comandos ");
                    sendText(chat_id, "/info ");
                    sendText(chat_id, "/progra ");
                    sendText(chat_id, "/hola ");
                    sendText(chat_id, "/cambio ");
                    sendText(chat_id, "para este dar un espacio y escribir lo que vamos a enviar por me dio del comando /grupal: ejemprlo /grupal hola  ");
                    sendText(chat_id, "/musica ");


                } else if (message_text.toLowerCase().equals("adios")) {
                    System.out.println("El chat_id del usuario es: " + chat_id);
                    sendText(chat_id, "adios que te valla bien " + nombre + ", ¡nice!");
                }
                else if (message_text.toLowerCase().equals("/info")){
                    System.out.println("El chat_id del usuario es: " + chat_id);
                    sendText(chat_id, "hahorita te muestro la info de Alan  , ¡ok !");
                    sendText(chat_id, "la carrera que esta cursando alan es la de ing en sistemas y le gusta jeje ❤️");
                    sendText(chat_id, "su numero de carne´ es el : 0905-23-15264");
                    sendText(chat_id, "su nombre completo es : Alan steven marroquin villaseñor");
                    sendText(chat_id,"El semestre que esta cursando es el cuarto semestre ya le hace ganas el muchacho 💕");
                    sendText(chat_id, "el curso que esta cursando el gran alan es el de progra 2 el cual tiene un ING que es un crack podemos decir que es un semi dios ❤️😎💪");
                }
                else if (message_text.toLowerCase().equals("/progra")){
                    System.out.println("El chat_id del usuario es: " + chat_id);
                    sendText(chat_id, "pues la clase que a  alan le parece de progra 2 es supergenial❤️  cada sabado estamos aprendiendo algo nuevo y esta super emoncionado🤩 por aprender mas🤯");
                }
                else if (message_text.toLowerCase().equals("/hola")){

                    sendText(chat_id, "hola :" + nombre+ "✌️✨" );
                    sendText(chat_id, "la fecha y hora  es : " + fecha.format(hora));
                    sendText(chat_id, "espero   que este dia te la pases supergenial y recuerda no todo esta perdido ✌️");
                    System.out.println("El chat_id del usuario es: " + chat_id);

                }
                if (message_text.startsWith("/cambio")){
                    try {
                        double euros = Double.parseDouble(message_text.split(" ")[1]); // Obtener cantidad de euros
                        double quetzales = euros * EURO_TO_QUETZAL_RATE; // Convertir a quetzales
                        String response = euros + " Euros son " + quetzales + " Quetzales"; // Crear respuesta
                        sendText(chat_id, "la cantidad es " + response);
                        System.out.println("El chat_id del usuario es: " + chat_id);
                    }
                    catch (NumberFormatException e) {
                        sendText(chat_id, "la cantidad es incorrecta");

                    }
                }
                else if (message_text.toLowerCase().equals("/musica")){
                    sendText(chat_id, "https://open.spotify.com/intl-es/track/5jFA0f4ZDGLbQP4nxzL8D4?si=3f24d628b6874549");
                    sendText(chat_id, "segunda opcion de musica:  " + "https://open.spotify.com/intl-es/track/0GfWTZZOc7co6oVqyQ556l?si=7eb4c82d3b344e91");
                    sendText(chat_id, "prueba de musica disfrutala😎😁");
                    System.out.println("El chat_id del usuario es: " + chat_id);
                }
                else if (message_text.toLowerCase().equals("andotriste")){
                    sendText(chat_id, "te entiendo apesar de ser una maquina pero recuerda todo va estar bien no te desanimes tu puedes apesar de lo que digan los demas tu confia en tus instintos no te dejes llevar por los demas tu puedes campion o campiona te quiere tu amigo virtual bot alan xd ❤️😁 ");

                    System.out.println("El chat_id del usuario es: " + chat_id);

                }
                if (message_text.startsWith("/grupal ")) {
                    String mensajeParaEnviar = message_text.substring(8); // Obtiene el texto después de "/grupal "

                    // Enviar el mensaje a cada compañero
                    for (long chatId : CHAT_IDS) {
                        sendText(chatId, mensajeParaEnviar);
                    }
                }




            }
        }

        public void sendText(Long who, String what) {
            SendMessage sm = SendMessage.builder()
                    .chatId(who.toString())  // A quién le estamos enviando un mensaje
                    .text(what).build();      // Contenido del mensaje
            try {
                execute(sm);                 // Enviando el mensaje
            } catch (TelegramApiException e) {
                throw new RuntimeException(e); // Cualquier error se captura aquí
            }


        }
    }

