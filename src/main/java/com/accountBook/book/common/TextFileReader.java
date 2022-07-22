package com.accountBook.book.common;

import com.accountBook.book.dto.CompanyBuilder;
import com.accountBook.book.dto.CompanyDto;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class TextFileReader {
    static String location = "D:\\dartProgram\\2022_1분기보고서_01_재무상태표_20220608utf8.txt";

    public BufferedReader getFile(String location)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(location)));
//        List<String> lines = Files.readAllLines(Paths.get(location));
        String line = null;
        HashSet<String> set = new HashSet<>();
        HashMap<String, String> map = new HashMap<>();
        List<CompanyDto> list = new ArrayList<>();

        while ((line = br.readLine()) != null){
//            System.out.println(line);
            String[] splits = line.split("\t");
            if(splits.length > 10){
                String temp = splits[10];
                if(     temp.equals("ifrs-full_Assets") || // 자산총계
                        temp.equals("ifrs-full_Liabilities")  || // 부채총계
                        temp.equals("ifrs-full_EquityAndLiabilities")  || // 자본과 부채총계
                        temp.equals("ifrs-full_RetainedEarnings")  || // 이익잉여금
                        temp.equals("ifrs-full_CurrentAssets")  || // 유동자산
                        temp.equals("ifrs-full_NoncurrentAssets")  || // 비유동자산
                        temp.equals("ifrs-full_CurrentLiabilities")  || // 유동부채
                        temp.equals("ifrs-full_NoncurrentLiabilities") // 비유동부채
                ){
                    String key = splits[1].replace("[", "").replace("]", "").trim();
                    String name = splits[2].trim();
                    String Ymd = splits[7].trim();
                    String Mm = splits[6].trim();
                    String quarter_kr = splits[8].trim();
                    String subject = splits[11].trim();
                    String subject_eng =  splits[10].trim();
                    String amount = splits[splits.length-1];

                    CompanyBuilder companyBuilder = new CompanyBuilder();
                    CompanyDto company = companyBuilder.setKey(key)
                            .setName(name)
                            .setSubject(subject)
                            .setSubjectEng(subject_eng)
                            .setYmd(Ymd)
                            .setMm(Mm)
                            .setQuarter_kr(quarter_kr)
                            .setAmount(amount).build();
                    list.add(company);
                }
            }
        }
        /*
         * ifrs-full_Assets
         * ifrs-full_Liabilities
         * ifrs-full_EquityAndLiabilities
         * ifrs-full_RetainedEarnings
         * */
        for(CompanyDto company : list){
            System.out.println(company.toString());
        }
        return br;
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(location)));
////        List<String> lines = Files.readAllLines(Paths.get(location));
//        String line = null;
//        HashSet<String> set = new HashSet<>();
//        HashMap<String, String> map = new HashMap<>();
//        List<Company> list = new ArrayList<>();
//
//        System.out.println(br.readLine());
//        System.out.println(br.readLine());
//    }
}
