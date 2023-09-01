/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package component.managment.system;
import javax.swing.*;
import java.io.*;
import javax.swing.table.TableModel;
/**
 *
 * @author Hardik Bhadru
 */
public class Exporter {
    Available_Comp a=new Available_Comp();
    public void exportTable(JTable table,File file)throws IOException
    {
        TableModel model=a.jTable1.getModel();
        FileWriter out=new FileWriter(file);
        //BufferedWriter bw=new BufferedWriter(out);
        for(int i=0;i<model.getColumnCount();i++)
        {
            out.write(model.getColumnName(i)+ "\t");
        }
        out.write("\n");
        for(int i=0;i<model.getRowCount();i++)
        {
            for(int j=0;j<model.getColumnCount();j++)
            {
                out.write(model.getValueAt(i,j).toString()+ "\t");
            }
            out.write("\n");
        }
        out.close();
    }
}
