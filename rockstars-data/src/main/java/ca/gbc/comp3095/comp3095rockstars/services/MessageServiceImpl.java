package ca.gbc.comp3095.comp3095rockstars.services;

import ca.gbc.comp3095.comp3095rockstars.model.Message;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MessageServiceImpl implements MessageService{
    @Override
    public Set<Message> findAll() {
        return null;
    }

    @Override
    public Message findById(Long aLong) {
        return null;
    }

    @Override
    public void delete(Message object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
