package ca.gbc.comp3095.comp3095rockstars.model;

public class Role extends BaseEntity{
    private String roleTitle;
    private User user;

    public Role(String roleTitle) {
        this.roleTitle = roleTitle;
    }

    public String getRoleTitle() {
        return roleTitle;
    }

    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
