/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.virtualizationprojectone;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.openstack4j.api.Builders;
import static org.openstack4j.api.Builders.image;
import static org.openstack4j.api.Builders.project;
import org.openstack4j.api.OSClient.OSClientV3;
import org.openstack4j.api.exceptions.AuthenticationException;
import org.openstack4j.openstack.OSFactory;
import org.openstack4j.model.common.Identifier;
import org.openstack4j.model.compute.Action;
import org.openstack4j.model.compute.Flavor;
import org.openstack4j.model.compute.Image;
import org.openstack4j.model.compute.Server;
import org.openstack4j.model.compute.ServerCreate;
import org.openstack4j.model.identity.v3.Authentication.Scope.Project;
import org.openstack4j.model.identity.v3.Token;
import org.openstack4j.model.identity.v3.User;
import org.openstack4j.model.network.Network;
/**
 *
 * @author prati
 */
public class DashboardServlet extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()){
            OSFactory.enableHttpLoggingFilter(true);
            System.out.println("com.mycompany.virtualizationprojectone.DashboardServlet.doPost()");
            OSClientV3 os = OSFactory.builderV3()
                        .endpoint("http://127.0.0.1:5000/v3")
                        .credentials("admin", "admin_user_secret",Identifier.byId("default"))
                        .scopeToProject(Identifier.byName("admin"), Identifier.byId("default"))
                        .authenticate();

            /*Token tok = os.getToken();
            System.out.println("Token:"+tok);
            //list images    
            String userImage="cirros";
            String userFlavor="MY-SMALL";
            String userNetwork="provider"; 
             String idNetwork=null;
            //Image img = os.compute().images().get("imageId");
            List<? extends Network> networks = os.networking().network().list();
            for(int i=0;i<networks.size();i++) 
            {
                //System.out.println("network "+networks.get(i));
                 String str=networks.get(i).toString();
                if(str.contains("name="+userNetwork))
                {
                    
                     int v1 = str.indexOf("id=")+3;
                     //int v2 = str.indexOf(",");
                     
                     System.out.println("v1"+v1);
                     //System.out.println("v2"+v2);
                     
                    idNetwork = str.substring(v1);
                    
                    String[] split = idNetwork.split(",");
                    String firstSubString = split[0];
                    
                  
                  
                   // System.out.println("network:"+str);
                    System.out.println("network id:"+firstSubString);
                    break;
                }
            }
            
            
            
             
             List<? extends Flavor> flavors = os.compute().flavors().list();
             String idFlavor=null;
            for(int i=0;i<flavors.size();i++) 
            {
                String str=flavors.get(i).toString();
                if(str.contains("name="+userFlavor))
                {
                    idFlavor = str.substring(str.indexOf("=")+1, str.indexOf(","));
                    System.out.println("Flavor:"+str);
                    System.out.println("userFlavor id:"+idFlavor);
                    break;
                }
            }
             
             
            List images = os.images().list();
            String idImage=null;
            for(int i=0;i<images.size();i++) 
            {
                
                String str=images.get(i).toString();
                if(str.contains("name="+userImage))
                {
                    idImage = str.substring(str.indexOf("=")+1, str.indexOf(","));
                    System.out.println("Images:"+str);
                    System.out.println("result id:"+idImage);
                    break;
                }
                
               
            }
            Random rdRandom=new Random();
            
            String userOsName="Ubuntu"+String.valueOf(rdRandom.nextInt());
            ServerCreate sc = Builders.server()
                                .name(userOsName)
                                .flavor(idFlavor)
                                .image(idImage)
                                .build();
            Server server = os.compute().servers().boot(sc);
            String serverId=server.getId();
            System.out.println("server1 created:"+serverId);
            
            os.compute().servers().action(server.getId(), Action.START);
            
           
            
           os.compute().servers().delete(serverId);
            
           System.out.println("server1 deleted:"+serverId);*/
           
            List<? extends Server> serverList = os.compute().servers().list();
            
            for(int i=0;i<serverList.size();i++) {
                System.out.println("serverList "+serverList.get(i));
                //out.println("projects "+projectList.get(i));
            }
            
            
            
            //os.compute().servers().action(server.getId(), Action.START);
            
           // System.out.println("server2:"+server);
            
            //String status=server.getStatus().toString();
            
           // System.out.println("status:"+status);
            
            
            //list flavors
            /**/
            //create project
            //org.openstack4j.model.identity.v3.Project project = os.identity().projects().create(Builders.project()
            //                                                    .name("newproject1")
            //                                                    .description("This is a new project.")
            //                                                    .enabled(true)
            //                                                    .build());    
            /*List<? extends org.openstack4j.model.identity.v3.Project> projectList = os.identity().projects().list();
            for(int i=0;i<projectList.size();i++) {
                System.out.println("himangini "+projectList.get(i));
                out.println("projects "+projectList.get(i));
            }*/
            //create a server
           
           /* 
                   
            // List all Servers
            List<? extends Server> servers = os.compute().servers().list();
            for(int i=0;i<servers.size();i++) {
                System.out.println("servers "+servers.get(i));
                out.println("servers "+servers.get(i));
            }
            // List all servers (light) ID, Name and Links populated
            List<? extends Server> allservers = os.compute().servers().list(false);
            for(int i=0;i<allservers.size();i++) {
                System.out.println("allservers "+allservers.get(i));
                out.println("allservers "+allservers.get(i));
            }
            // Get a specific Server by ID
            Server serverbyid = os.compute().servers().get("serverId");
            System.out.println("serverbyid "+serverbyid);
            out.println("serverbyid "+serverbyid);
            //for(int i=0;i<serverbyid.size();i++) {
            //    System.out.println("serverbyid "+serverbyid.get(i));
            //    out.println("serverbyid "+serverbyid.get(i));
            //}
            //delete instance
//            os.compute().servers().delete("serverId");
            //stop a server
            os.compute().servers().action(server.getId(), Action.STOP);
                   */ 
        } catch(AuthenticationException e) {
            e.printStackTrace();
        }
    }
}
