import java.io.*;

public class FileService
{
    static String filePath="users.txt";

    public static void save()
    {
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(filePath)))
        {
            for (User u:BackendService.getAllUsers())
            {
                bw.write(u.id+","+u.name+","+u.email);
                bw.newLine();
            }
        }
        catch(Exception e)
        {
            System.out.println("Save failed");
        }
    }

    public static void load()
    {
        try(BufferedReader br=new BufferedReader(new FileReader(filePath)))
        {
            String line;
            while((line=br.readLine())!=null)
            {
                String[] p=line.split(",");
                BackendService.addUser(
                    new User(Integer.parseInt(p[0]),p[1],p[2])
                );
            }
        }
        catch(Exception e)
        {
            System.out.println("No previous data");
        }
    }
}