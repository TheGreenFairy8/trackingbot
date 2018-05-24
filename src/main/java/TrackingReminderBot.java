import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;

import java.io.File;
import java.util.Random;

public class TrackingReminderBot extends TelegramLongPollingBot
{
    String[] remindMessages = new String[]
            {
                    "Трекайтес",
                    "Трекайте-с, господа",
                    "Tracking time!",
                    "'главное не работа, а затреканное время!'©",
                    "'Трекаемся'©",
                    "Ребята, давайте дружно трекаться!"
            };

    public String getBotUsername()
    {
        return "TrackingReminderBot";
    }

    @Override
    public String getBotToken()
    {
        return "541442621:AAHeBQlBTU6xxWL8UkCLcarJwEFE0IL17c0";
    }

    public void onUpdateReceived(Update update)
    {
        Message message = update.getMessage();
        if (message != null && message.hasText())
        {
            if (message.getText().equals("/help"))
                sendMsg(message, "Я здесь, чтобы напоминать");
            else
                sendMsg(message, "Я маленький бот, не обижайте меня(");
        }
    }

    private void sendMsg(Message message, String text)
    {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);

        try
        {
            sendMessage(sendMessage);
        } catch (TelegramApiException e)
        {
            e.printStackTrace();
        }
    }

    public void sendImage(String chatId, File image)
    {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setNewPhoto(image);
        sendPhoto.setChatId(chatId);
        sendPhoto.setCaption(remindMessages[new Random().nextInt(remindMessages.length)]);
        try
        {
            sendPhoto(sendPhoto);
        } catch (TelegramApiException e)
        {
            e.printStackTrace();
        }
    }
}
