package hiber.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;


import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;


    @ManyToMany(mappedBy = "roles")
    @Transient
    private Set<User> user;


    public Role() {
    }

    public Role (Long id) {
        this.id = id;
    }

    public Role (Long id, String name) {
        this.id = id;
        this.name = name;
    }




    @Override
    public String getAuthority() {
        return getName();
    }


//    public Long getId() {
//        return this.id;
//    }
//
//    public String getName() {
//        return this.name;
//    }
//
//    public Set<User> getUser() {
//        return this.user;
//    }
//
//    public void setId(final Long id) {
//        this.id = id;
//    }

//    public void setName(final String role) {
//        this.name = role;
//    }
//
//    public void setUser(final Set<User> user) {
//        this.user = user;
//    }
//
//    public boolean equals(final Object o) {
//        if (o == this) {
//            return true;
//        } else if (!(o instanceof Role)) {
//            return false;
//        } else {
//            Role other = (Role)o;
//            if (!other.canEqual(this)) {
//                return false;
//            } else {
//                label47: {
//                    Object this$id = this.getId();
//                    Object other$id = other.getId();
//                    if (this$id == null) {
//                        if (other$id == null) {
//                            break label47;
//                        }
//                    } else if (this$id.equals(other$id)) {
//                        break label47;
//                    }
//
//                    return false;
//                }

//                Object this$role = this.getName();
//                Object other$role = other.getName();
//                if (this$role == null) {
//                    if (other$role != null) {
//                        return false;
//                    }
//                } else if (!this$role.equals(other$role)) {
//                    return false;
//                }
//
//                Object this$user = this.getUser();
//                Object other$user = other.getUser();
//                if (this$user == null) {
//                    if (other$user != null) {
//                        return false;
//                    }
//                } else if (!this$user.equals(other$user)) {
//                    return false;
//                }
//
//                return true;
//            }
//        }
//    }
//
//    protected boolean canEqual(final Object other) {
//        return other instanceof Role;
//    }

//    public int hashCode() {
//        int result = 1;
////        Object $id = this.getId();
////        result = result * 59 + ($id == null ? 43 : $id.hashCode());
////        Object $role = this.getRole();
////        result = result * 59 + ($role == null ? 43 : $role.hashCode());
////        Object $user = this.getUser();
////        result = result * 59 + ($user == null ? 43 : $user.hashCode());
//        return result;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, user);
//    }
//
//    public String toString() {
//        Long var10000 = this.getId();
//        return "Role(id=" + var10000 + ", role=" + this.getName() + ", user=" + this.getUser() + ")";
//    }

}
