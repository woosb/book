package com.accountBook.company.common;

import com.accountBook.company.domain.entity.Company;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class DartFileParser {

    public void parsingCLI() throws IOException, SQLException {
        StringBuilder sb = new StringBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StatementEnum[] statements = StatementEnum.values();
        int index = 0;
        for(StatementEnum statement : statements){
            System.out.println(++index+". " +statement.name());
        }

        int selected = reader.read() - '0' -1;
        reader.readLine();
        StatementEnum statement = statements[selected];

        sb.append(statement.path());
        File[] ymds = new File(sb.toString()).listFiles();

        index = 0;
        assert ymds != null;
        for(File file : ymds){
            System.out.println(++index + ". " +file.getName());
        }

        selected = reader.read() - '0' -1;

        String ymd = "/"+ymds[selected].getName();
        sb.append(ymd);

        String path = sb.toString();
        File dir = new File(path);

        parseFile(Objects.requireNonNull(dir.listFiles()));
    }

    public void parseFile(File[] files) throws IOException, SQLException {
        for(File file : files){
            parseFile(file);
        }
    }

    public List<Company> parseFile(File file) throws IOException, SQLException {
//        String encoding = readEncoding(file);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));

        HashSet<String> set = new HashSet();
        List<Company> companys = new ArrayList();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "euc_kr"));
        String str;
        reader.readLine();
        while ((str = reader.readLine()) != null) {
            String[] split = str.split("\t");
            if(split.length > 12) {
                String code       = split[1].trim().replace("[","").replace("]","");
                String name       = split[2].trim();
                String market     = split[3].trim();
                String sectorcode = split[4].trim();
                String sectorname = split[5].trim();

                if(set.contains(code)){
                }else{
                    Company company = Company.builder().code(code).name(name).market(market).sectorCode(sectorcode).sectorName(sectorname).build();
                    companys.add(company);
                    set.add(code);
                }
            }
        }
        reader.close();
        return companys;
    }
}
