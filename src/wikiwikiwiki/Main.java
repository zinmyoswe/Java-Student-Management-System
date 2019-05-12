/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wikiwikiwiki;
import java.io.*;
import java.util.*;
import java.io.FileWriter;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Main 
{
    
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<String> Arrrevert;
    
    static ArrayList<User> ArrUser;
    static ArrayList<Student> ArrStudent;
    static ArrayList<Tutor> ArrTutor;
    static ArrayList<Admin> ArrAdmin;
    static ArrayList<Pages>ArrPages;
    static ArrayList<History>ArrHistory;
    static ArrayList<UserPermission>ArrPermission;
    
    static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    
    static boolean Enter=true;
    private static int input;
    private static String LoginUserID;
   
    public static void main(String[] args) throws Exception
    {
       
        ArrUser=new ArrayList<User>();
        ArrStudent=new ArrayList<Student>();
        ArrTutor=new ArrayList<Tutor>();
        ArrAdmin=new ArrayList<Admin>();
        ArrPages=new ArrayList<Pages>();
        ArrHistory=new ArrayList<History>();
         ArrPermission=new ArrayList<UserPermission>();
                
        while(true)
        {
        System.out.println("\n===========================\n");
        System.out.println("1.Login ");
        System.out.println("2.Register");
        System.out.println("3.Exit");
       
        input=Integer.parseInt(br.readLine());
        
        switch(input)
        {
            
            case 1:
                  System.out.println("\n============User Login ===============\n");
                  String ret_userType=CheckUserType();
                  String type=null;
                  String name=null;
                  String password=null;

                  
                   if(ret_userType.equals("1"))
                      {
                          type="Student";
                          System.out.println("Type Student Name     |");
                          name=br.readLine();
                          System.out.println("Type password         |");
                          password=br.readLine();
                          CheckLogin(type,name,password);
                      }
                   
                   
                   else if(ret_userType.equals("2"))
                    {
                       type="Tutor";
                       System.out.println("Type Tutor Name          |");
                       name=br.readLine();
                       System.out.println("Type password            |");
                       password=br.readLine();
                       CheckLogin(type,name,password);
                    }
                   
                   
                   else if(ret_userType.equals("3"))
                    {
                        type="Admin";
                        System.out.println("Type Admin name         |");
                        name=br.readLine();
                        System.out.println("Type password           |");
                        password=br.readLine();
                        CheckLogin(type,name,password);
                    }
            break;

            case 2:
                  System.out.println("\n============User Register ===============\n");
                  ret_userType=CheckUserType();
                  Student objStudent=new Student();
                  Tutor objTutor=new Tutor();
                  Admin objAdmin=new Admin();

                  
                  if(ret_userType.equals("1"))
                    {
                        objStudent.setUserTypeID("Student");
                        System.out.println("Enter Student ID        |");
                        objStudent.setUserID(br.readLine());
                        System.out.println("Enter Student Name      |");
                        objStudent.setUserName(br.readLine());
                        System.out.println("Enter Password          |");
                        objStudent.setPassword(br.readLine());
                        System.out.println("Enter Section NO        |");
                        objStudent.setSectionNO(br.readLine());
                        ArrUser.add(objStudent);
                        System.out.println("\n=========== Student data Saved =========\n");
                    }
                 
                  
                else if(ret_userType.equals("2"))
                    {
                        objTutor.setUserTypeID("Tutor");
                        System.out.println("Enter Tutor ID          |");
                        objTutor.setUserID(br.readLine());
                        System.out.println("Enter Tutor Name        |");
                        objTutor.setUserName(br.readLine());    
                        System.out.println("Enter Password          |");
                        objTutor.setPassword(br.readLine());
                        System.out.println("Enter Department        |");
                        objTutor.setDepartment(br.readLine());
                        System.out.println("Enter Position          |");
                        ArrUser.add(objTutor);
                        System.out.println("\n============ Tutor data Saved ==========\n");
                    }
                
                else if(ret_userType.equals("3"))
                    {
                        objAdmin.setUserTypeID("Admin");
                        System.out.println("Enter Admin ID          |");
                        objAdmin.setUserID(br.readLine());
                        System.out.println("Enter Admin Name        |");
                        objAdmin.setUserName(br.readLine());
                        System.out.println("Enter Password          |");
                        objAdmin.setPassword(br.readLine());
                        ArrUser.add(objAdmin);
                        System.out.println("\n============ Admin data Saved ==========\n");
                    }
            break;
                
                
            case 3:
                  System.out.println("Exit Program");
                  System.exit(0);
            break;

        }//switch
    }//while
}//main

//------------------------------------------------------------------------------
    private static String CheckUserType() throws Exception
    {
             System.out.println("\n=========== Choose User Type ===========\n");
             System.out.println("1. Student");
             System.out.println("2. Tutor");
             System.out.println("3. Admin");
             String input=br.readLine();
             return input;
    }
//------------------------------------------------------------------------------    
    
//------------------------------------------------------------------------------
    private static void CheckLogin(String t,String n,String p) throws Exception
    {
        for(int i=0;i<ArrUser.size();i++)
        {
             if(ArrUser.get(i).getUserTypeID().equals(t) && ArrUser.get(i).getUserName().equals(n)&& ArrUser.get(i).getPassword().equals(p))
             {
                if(t.equals("Admin"))
                 {
                    
                    
                        LoginUserID=ArrUser.get(i).getUserID();
                        AdminProcess();
                    
                 }

                if(t.equals("Student"))
                 {
                    
                    
                        LoginUserID=ArrUser.get(i).getUserID();
                        StudentProcess();
                    
                 }
                 if(t.equals("Tutor"))
                 {
                    
                    
                        LoginUserID=ArrUser.get(i).getUserID();
                        TutorProcess();
                    
                 }
                 
                
             }
        }
   }
//------------------------------------------------------------------------------

//------------------------------------------------------------------------------
private static void StudentProcess() throws Exception
{
     System.out.println("\n============== Students process===============\n");
     System.out.println("1)View Pages           ");
     System.out.println("2)Edit Pages           ");
     System.out.println("3)Log Out              ");
     int student_input=Integer.parseInt(br.readLine());

     Pages objpages=new Pages();
     Date date = new Date();
    switch(student_input)
    {
    case 1:
        System.out.println("PageID \t PageTitle \t Description");
         for(int Pages=0; Pages<ArrPages.size(); Pages++)
        {

            System.out.println(ArrPages.get(Pages).getPageID() +"\t\t"+
                               ArrPages.get(Pages).getPageTitle() +"\t\t"+
                               ArrPages.get(Pages).getDescription());
        }//end of for loop
        break;

    case 2:
             String PageID, PageTitle, Description;
        int index=0;
        System.out.println("\n========= All Pages ===========\n");
        System.out.println("PageID \t PageTitle \t Description");
        for(int pages=0; pages<ArrPages.size();pages++)
         {
             for(int uper=0; uper<ArrPermission.size(); uper++)
             {
                if(ArrPages.get(pages).getPageID().toString().equals(ArrPermission.get(uper).getPageID().toString()))
                {

                    System.out.println(ArrPages.get(pages).getPageID() +"\t\t"+
                                       ArrPages.get(pages).getPageTitle() +"\t\t"+
                                       ArrPages.get(pages).getDescription());
                }//end of for loop
             }
        }
        System.out.println("Type Page ID    |");
        PageID=br.readLine();
        PageTitle=br.readLine();
        Description=br.readLine();
        for(int Pages=0; Pages<ArrPages.size(); Pages++)
        {
        if(ArrPages.get(Pages).getPageID().equals(PageID))
        {
            PageTitle=ArrPages.get(Pages).getPageTitle().toString();
            Description=ArrPages.get(Pages).getDescription().toString();
            index=Pages;
           }//end of if
         }//end of for loop
        System.out.println("Type New Title          |");
        String NewTitle=br.readLine();
        System.out.println("Type New Description    |");
        String NewDescription=br.readLine();
        ArrPages.get(index).setPageTitle(NewTitle);
        ArrPages.get(index).setDescription(NewDescription);
        System.out.println("\n========== Successfully Update ==========\n");
        AddHistory(PageID,PageTitle+','+
                   Description,NewTitle+","+
                   NewDescription,LoginUserID,
                   String.valueOf(dateFormat.format(date)));
         
        break;

    case 3:
        System.out.println("\n========== Log Out Successful ==========\n");
        Enter=false;
        break;
}
}
//------------------------------------------------------------------------------
private static void TutorProcess() throws Exception
{
     System.out.println("\n============== Tutors process===============\n");
     System.out.println("1)View Pages           ");
     System.out.println("2)Edit Pages           ");
     System.out.println("3)Log Out              ");
  int Tutor_input=Integer.parseInt(br.readLine());
  Pages objpages=new Pages();
     Date date = new Date();
    switch(Tutor_input)
    {
        case 1:
            for(int Pages=0; Pages<ArrPages.size(); Pages++)
             {
                System.out.println("PageID \tPageTitle \tDescription");
                System.out.println(ArrPages.get(Pages).getPageID() +"\t"+
                                   ArrPages.get(Pages).getPageTitle() +"\t"+
                                   ArrPages.get(Pages).getDescription());
             }//end of for loop
            break;

        case 2:
            String PageID, PageTitle, Description;
            int index=0;
            System.out.println("\n========= Edit Pages ===========\n");
            System.out.println("PageID \tPageTitle \tDescription");
            for(int pages=0; pages<ArrPages.size();pages++)
             {
              for(int uper=0; uper<ArrPermission.size(); uper++)
               {
                if(ArrPages.get(pages).getPageID().toString().equals(ArrPermission.get(uper).getPageID().toString()))
                {

                    System.out.println(ArrPages.get(pages).getPageID() +"\t\t"+
                                       ArrPages.get(pages).getPageTitle() +"\t\t"+
                                       ArrPages.get(pages).getDescription());
                }//end of for loop
               }
             }
            System.out.println("Type Page ID            |");
            PageID=br.readLine();
            PageTitle=br.readLine();
            Description=br.readLine();
            for(int Pages=0; Pages<ArrPages.size(); Pages++)
             {
            if(ArrPages.get(Pages).getPageID().equals(PageID))
               {
                PageTitle=ArrPages.get(Pages).getPageTitle().toString();
                Description=ArrPages.get(Pages).getDescription().toString();
                index=Pages;
               }//end of if
             }//end of for loop
            System.out.println("Type New Title          |");
            String NewTitle=br.readLine();
            System.out.println("Type New Description    |");
            String NewDescription=br.readLine();
            ArrPages.get(index).setPageTitle(NewTitle);
            ArrPages.get(index).setDescription(NewDescription);
            System.out.println("\n========== Successfully Update ==========\n");
            AddHistory(PageID,PageTitle+','+
                       Description,NewTitle+","+
                       NewDescription,LoginUserID,
                       String.valueOf(dateFormat.format(date)));
            break;

        case 3:
            System.out.println("\n========== Log Out Successful ==========\n");
            Enter=false;
            break;
    }
}
//------------------------------------------------------------------------------    
private static void AdminProcess() throws Exception
{   
     System.out.println("\n============== Admin process===============\n");
     System.out.println("1)View User List       ");
     System.out.println("2)Add Pages            ");
     System.out.println("3)Edit Pages           ");
     System.out.println("4)View Pages           ");
     System.out.println("5)Export to HTML       ");
     System.out.println("6)View History         ");
     System.out.println("7)Revert Change        ");
     System.out.println("8)Add User Permission  ");
     System.out.println("9)Log Out              ");
     
     int admin_input=Integer.parseInt(br.readLine());
     Pages objpages=new Pages();
     Date date = new Date();
     
     switch (admin_input)
     {
         case 1:
               System.out.println("\n==========All User List in Wiki============\n"); 
               UserView();
         break;
//------------------------------------------------------------------------------
    
//------------------------------------------------------------------------------        
         case 2:
               System.out.println("\n============== Add New Pages ==============\n");
               System.out.println("Enter Page ID            |");
               objpages.setPageID(br.readLine());
               System.out.println("Enter Page Title         |");
               objpages.setPageTitle(br.readLine());
               System.out.println("Enter Description        |");
               objpages.setDescription(br.readLine());
               ArrPages.add(objpages);
               System.out.println("\n============= Pages Data Saved ============\n");
         break;
//------------------------------------------------------------------------------
   
//------------------------------------------------------------------------------        
         case 3:

               System.out.println("\n================ Edit Pages ===============\n");
               System.out.println("Enter Page ID to Update  |");
               String PgID=br.readLine();
               int index=0;
               String PageName=null, Description=null;
               
               for(int p=0; p<ArrPages.size(); p++)
               {
                   if(ArrPages.get(p).getPageID().toString().equals(PgID))
                   {
                        System.out.println("\n=============== Current Pages =============\n");
                        System.out.println("PageID \t\tPageTitle \tDescription");
                        
                        PageName=ArrPages.get(p).getPageTitle();
                        Description=ArrPages.get(p).getDescription();
                        index=p;
                        
                        System.out.print(PgID +"\t \t");
                        System.out.print(PageName +"\t \t");
                        System.out.println(Description+ "\n");
                    }
               }
               System.out.println("\n================ Update Pages =============\n");
               System.out.println("Type Page Title");
               String newPN=br.readLine();
               System.out.println("Type Description");
               String newPD=br.readLine();
                        
               ArrPages.get(index).setDescription(newPD);
               ArrPages.get(index).setPageTitle(newPN);
               System.out.println("\n============== Pages Updated ==============\n");
               AddHistory(PgID, PageName +","+Description, newPN +","+newPD, LoginUserID, String.valueOf(dateFormat.format(date)));
         break;
//------------------------------------------------------------------------------
             
//------------------------------------------------------------------------------     
         case 4:
               System.out.println("\n========== All Page List in Wiki ==========\n");
               System.out.println("PageID \t\tPageTitle \tDescription");
               
               for(int page=0; page<ArrPages.size();page++)
                {
                    String PageID=ArrPages.get(page).getPageID();
                    PageName=ArrPages.get(page).getPageTitle();
                    Description=ArrPages.get(page).getDescription();
                    
                    System.out.print(PageID +"\t \t");
                    System.out.print(PageName +"\t \t");
                    System.out.println(Description+ "\n");
                }
         break;
//------------------------------------------------------------------------------
    
//------------------------------------------------------------------------------    
         case 5:
               System.out.println("\n============= Export to HTML ==============\n");
               System.out.println("Type File Name");
               String str=null;
               for(int i=0; i<ArrPages.size(); i++)
                {
                    str=new String (ArrPages.get(i).getDescription().toString());
                }
               System.out.println("Type File Name");
               File hisfile = new File(br.readLine()+".html");
               hisfile.createNewFile();
               FileWriter  writer = new FileWriter(hisfile);
               writer.write(str.replace("**","<b>"));
               writer.flush();
               writer.close();
               System.out.println("\n============= Export Completed ============\n");
         break;
//------------------------------------------------------------------------------
             
             
//------------------------------------------------------------------------------    
         case 6:
               System.out.println("\n========= All History List in Wiki ========\n");
               HistoryView();
         break;
//------------------------------------------------------------------------------
             
//------------------------------------------------------------------------------    
         case 7:
               RevertChange();
         break;
//------------------------------------------------------------------------------

//------------------------------------------------------------------------------
         case 8:
               System.out.println("\n============= User Permission =============\n");
               UserPermission objper=new UserPermission();
               UserView();
               System.out.println("Type User ID");
               objper.setUserID(br.readLine());
               System.out.println("Type Page ID");
               objper.setPageID(br.readLine());
               ArrPermission.add(objper);
               System.out.println("\n============= Permission Saved=============\n");
         break;
//------------------------------------------------------------------------------

//------------------------------------------------------------------------------    
         case 9:
               System.out.println("\n============ Log Out SuccessFul!===========\n");
               Enter=false;
         break;
//------------------------------------------------------------------------------
 
     }
}
//------------------------------------------------------------------------------

//------------------------------------------------------------------------------
private static void AddHistory(String PID, String OD,String ND, String UID,String EDate) throws IOException
{
    History objhistory=new History();
    HistoryView();
    System.out.println("Type History ID");
    objhistory.setHistoryID(br.readLine());
    objhistory.setPageID(PID);
    objhistory.setOldData(OD);
    objhistory.setNewData(ND);
    objhistory.setUserID(UID);
    objhistory.setEditDate(EDate);
    ArrHistory.add(objhistory);
    System.out.println("\n============ History Data Saved ===========\n");
}
//------------------------------------------------------------------------------

//------------------------------------------------------------------------------
private static void RevertChange() throws IOException
{
    Arrrevert=new ArrayList<String>();
    System.out.println("\n============== Revert History =============\n");
    HistoryView();
    System.out.println("Enter History ID to Update  |");
    String HID=br.readLine();
    int index=0;
    String Changes;
    
    for(int h=0; h<ArrHistory.size(); h++)
               {
                   if(ArrHistory.get(h).getHistoryID().toString().equals(HID))
                   {
                        System.out.println("\n=============== Current Pages =============\n");
                        System.out.println("PageID \t\tPageTitle \tDescription");
                        
                        Changes=ArrHistory.get(h).getOldData();
                        
                        for(int ch=0; ch<Changes.length(); ch++)
                        {
				String[] separated_data=Changes.split(",");
				
				for (String a: separated_data)
				{
					Arrrevert.add(a);
				}
			}
                        index=h;
                        ArrPages.get(index).setDescription(Arrrevert.get(1).toString());
                        ArrPages.get(index).setPageTitle(Arrrevert.get(0).toString());
                    }
               }           
    System.out.println("\n============ Revert Completed =============\n");
}
//------------------------------------------------------------------------------

//------------------------------------------------------------------------------
private static void HistoryView()
{
    System.out.println("Date \t\t\tOld Data \t\t\tNew Data \t\t\tEdit User");
    for(int his=0; his<ArrHistory.size();his++)
        {
            String EDate=ArrHistory.get(his).getEditDate();
            String OD=ArrHistory.get(his).getOldData();
            String ND=ArrHistory.get(his).getNewData();
            String UID=ArrHistory.get(his).getUserID();
                    
            System.out.print(EDate +"\t \t");
            System.out.print(OD +"\t \t");
            System.out.print(ND+ "\t \t");
            System.out.println(UID+ "\n");
        }
}
//------------------------------------------------------------------------------

//------------------------------------------------------------------------------
public static void UserView()
{
System.out.println("UserID \t\tUser Name \t\tUser Type");
               for(int user=0; user<ArrUser.size(); user++)
                {
                    String UserID=ArrUser.get(user).getUserID();
                    String UserName=ArrUser.get(user).getUserName();
                    String UserType=ArrUser.get(user).getUserTypeID();
                    
                    System.out.print(UserID +"\t \t");
                    System.out.print(UserName +"\t \t");
                    System.out.println(UserType + "\n");
                }
}
//------------------------------------------------------------------------------
}

