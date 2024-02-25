package kz.zhelezyaka.service;

public class DummyEmailService implements EmailService {
    @Override
    public void sendEmail(String message) {
        throw new AssertionError("Method has not been implemented yet.");
    }
}
