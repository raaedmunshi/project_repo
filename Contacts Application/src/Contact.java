public class Contact {

   
    String fname;
    String lname;
    String email;
    String number;
    String url;
    String loc;

    public String getEmail() {
        return email;
    }
     public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getLoc() {
        return loc;
    }

    public String getNumber() {
        return number;
    }

    public String getUrl() {
        return url;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Contact() {
         this.fname = "  ";
        this.lname = "  ";
        this.email = "  ";
        this.number = "  ";
        this.url = "  ";
        this.loc = "  ";
    }

    public Contact(String fname, String lname, String email, String number, String url, String loc) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.number = number;
        this.url = url;
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Contact{" + "fname=" + fname + ", lname=" + lname + ", email=" + email + ", number=" + number + ", url=" + url + ", loc=" + loc + '}';
    }
     
   
}
