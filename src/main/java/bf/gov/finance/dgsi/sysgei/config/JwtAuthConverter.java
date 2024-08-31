package bf.gov.finance.dgsi.sysgei.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
@SuppressWarnings("ALL")
public class JwtAuthConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    private static final String REALM_ACCESS_CLAIM = "realm_access";
    private static final String ROLES_CLAIM = "roles";

    /**
     * @param jwt the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return AbstractAuthenticationToken
     */
    @Override
    public AbstractAuthenticationToken convert(final Jwt jwt) {
        Collection<GrantedAuthority> authorities = extractAuthorities(jwt);
        return new JwtAuthenticationToken(jwt, authorities);
    }

    /**
     * Extration des rôles de l'utilisateur.
     *
     * @param jwt
     * @return Collection<GrantedAuthority>
     */
    private Collection<GrantedAuthority> extractAuthorities(final Jwt jwt) {
        if (jwt.getClaim(REALM_ACCESS_CLAIM) != null) {
            Map<String, Object> realmsAcess = jwt.getClaim(REALM_ACCESS_CLAIM);
            List<String> keyCloackRoles = (List<String>) realmsAcess.get(ROLES_CLAIM);
           // log.debug("-------{}", jwt);
            List<GrantedAuthority> authorities = new ArrayList<>();
            for (String role : keyCloackRoles) {
                authorities.add(new SimpleGrantedAuthority(role.toUpperCase()));
            }
            // log.debug("authorities: {}", authorities);
            return authorities;
        }
        return new ArrayList<>();
    }

}
