package Solutions;
public class StringOperations {
    public static void main(String[] args) {
        // Create a new String object and assign it your name. Print it out.
        String myName = "Bryce Paquette";
        System.out.println(myName);

        // Pick the first letter in your name, and replace it with 'A'. Then, replace the last letter in your name with 'Z'. Print out the result.
        myName = myName.replace(myName.charAt(0), 'Z');
        System.out.println(myName);

        // Declare a new String and give it the value of some web address, in the form www.name.tld, such as www.gatech.edu or www.stackoverflow.com. Print out this address.
        String webAddress = "www.github.com";
        System.out.println(webAddress);

        // Create a substring of the variable that's just the "name" section, and concatenate the integer "1331" to the end. For example, www.gatech.edu would become gatech1331. Print out this final result.
        String domain = webAddress.split("\\.")[1] + "1331";
        System.out.println(domain);
    }
}
