// package agriculture.com.app.config;

// import java.io.Serializable;

// import org.springframework.security.access.PermissionEvaluator;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.stereotype.Component;

// @Component
// public class CustomPermissionEvaluator implements PermissionEvaluator {

// @Override
// public boolean hasPermission(Authentication authentication, Object
// targetDomainObject, Object permission) {
// // TODO Auto-generated method stub
// // check null
// if ((authentication == null) || (targetDomainObject == null) || !(permission
// instanceof String)) {
// return false;
// }
// String targetType =
// targetDomainObject.getClass().getSimpleName().toUpperCase();

// return hasPrivilege(authentication, targetType,
// permission.toString().toUpperCase());
// }

// @Override
// public boolean hasPermission(Authentication authentication, Serializable
// targetId, String targetType,
// Object permission) {
// // TODO Auto-generated method stub

// if ((authentication == null) || (targetType == null) || !(permission
// instanceof String)) {
// return false;
// }
// return hasPrivilege(authentication, targetType.toUpperCase(),
// permission.toString().toUpperCase());
// }

// public boolean hasRole(Authentication authentication, Serializable targetId,
// String targetType, Object permission) {
// // TODO Auto-generated method stub
// return false;
// }

// private boolean hasPrivilege(Authentication authentication, String
// targetType, String permission) {
// for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
// if (grantedAuthority.getAuthority().startsWith(targetType)) {
// if (grantedAuthority.getAuthority().contains(permission)) {
// return true;
// }
// }
// }
// return false;
// }

// }
