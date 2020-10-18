package pwxon.redditclone.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pwxon.redditclone.dto.RegisterRequest;
import pwxon.redditclone.model.NotificationEmail;
import pwxon.redditclone.model.User;
import pwxon.redditclone.model.VerificationToken;
import pwxon.redditclone.repository.UserRepository;
import pwxon.redditclone.repository.VerificationTokenRepository;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final VerificationTokenRepository verificationTokenRepository;
    private final MailService mailService;
    private final Environment env;

    @Transactional
    public void signup(RegisterRequest registerRequest) {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername(registerRequest.getUsername());
        user.setPassword(this.passwordEncoder.encode(registerRequest.getPassword()));
        user.setEmail(registerRequest.getEmail());
        user.setCreatedAt(Instant.now());
        user.setEnabled(false);
        this.userRepository.save(user);

        String token = generateVerificationToken(user);
        String verificationUrl = this.env.getRequiredProperty("app.hostname")+"/api/auth/accountVerification/"+token;
        this.mailService.sendMail(
                new NotificationEmail(
                        "Registration on REDDIT",
                        user.getEmail(),
                        "Activation link: " + verificationUrl
                )
        );
    }

    public String generateVerificationToken(User user) {
        String uuidToken = UUID.randomUUID().toString();
        VerificationToken token = new VerificationToken();
        token.setId(UUID.randomUUID());
        token.setToken(uuidToken);
        token.setUser(user);

        this.verificationTokenRepository.save(token);

        return uuidToken;
    }
}
