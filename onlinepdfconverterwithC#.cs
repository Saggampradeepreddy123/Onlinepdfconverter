using System;

using System.Collections.Generic;

using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using iTextSharp;
using iTextSharp.text;
using iTextSharp.text.pdf;
using System.IO;

namespace PDF
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            using (OpenFileDialog file = new OpenFileDialog())
            {
                //Show the Dialog Box & Select the File
                file.ShowDialog();
                //Assign Input FileName to TextBox
                txtInput.Text = file.FileName;
                txtTextFile.Text= File.ReadAllText(file.FileName);
            }

            //Assign Output FileName to TextBox
            txtOutput.Text = (txtInput.Text).Replace(".txt", ".pdf");


        }

        private void btnExport_Click(object sender, EventArgs e)
        {
            //Read the Data from Input File
            StreamReader rdr = new StreamReader(txtInput.Text);
            //Create a New instance on Document Class
            Document doc = new Document();
            //Create a New instance of PDFWriter Class for Output File
            PdfWriter.GetInstance(doc, new FileStream(txtOutput.Text, FileMode.Create));
            //Open the Document
            doc.Open();
            //Add the content of Text File to PDF File
            doc.Add(new Paragraph(rdr.ReadToEnd()));
            //Close the Document
            doc.Close();
            MessageBox.Show("Conversion Successful....");
            //Open the Converted PDF File
            System.Diagnostics.Process.Start(txtOutput.Text);
        }
    }
}
