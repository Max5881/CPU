package ru.sapteh;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) throws IOException {
        File file = new File("ConfigurationList.txt");

        if(file.createNewFile()){
            System.out.println("Created file");
        }
        else System.out.println("File not Created");

        List<Configuration> configurationList = new ArrayList<>();
        try(BufferedReader fileReader = new BufferedReader(new FileReader(file))){
            while (fileReader.ready()){
                String[] read = fileReader.readLine().split(" ");
                Configuration configuration = new Configuration(Integer.parseInt(read[0]),read[1],read[2],read[3],read[4]);
                configurationList.add(configuration);
            }

        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите операцию : -c,-u,-d");
        String input = reader.readLine();
        if ("-c".equals(input)){
            BufferedReader modelCpu = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите модель процессора");
            String cpu = modelCpu.readLine();
            BufferedReader ramReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите обьем оперативной памяти");
            String ram = ramReader.readLine();
            BufferedReader hddReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите обьем памяти компьютера");
            String hdd = hddReader.readLine();
            BufferedReader powerSupplyReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите мощность блока питания");
            String powerSupply = powerSupplyReader.readLine();

            int id = 1;
            for (Configuration configuration : configurationList) {
                if (configuration.getId() > id) {
                    id = configuration.getId();
                }
            }
            Configuration configuration = new Configuration(id,cpu,ram,hdd,powerSupply);
            configurationList.add(configuration);
        }
        try(FileWriter fw = new FileWriter(file)){
            for (Configuration configuration : configurationList){
                fw.write(configuration.toString());
                fw.write("\n");
            }
        }
        if ("-d".equals(input)) {
            int idDelete;
            BufferedReader readerDelete = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите id для удаления");
            idDelete = readerDelete.read();
        }
    }
}
