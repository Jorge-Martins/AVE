package Emulator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Stats {
   private int[] map = new int[256];
   private ArrayList<Integer> instructions = new ArrayList<Integer>();
   private PrintWriter writer;
   
   private String s[] = { "NOP", "LD BC,nn", "LD (BC),A", "INC BC", "INC B", "DEC B", "LD B,n",
            "RLC A", "LD (nn),SP", "ADD HL,BC", "LD A,(BC)", "DEC BC", "INC C", "DEC C", "LD C,n",
            "RRC A", "STOP", "LD DE,nn", "LD (DE),A", "INC DE", "INC D", "DEC D", "LD D,n", "RL A",
            "JR n", "ADD HL,DE", "LD A,(DE)", "DEC DE", "INC E", "DEC E", "LD E,n", "RR A",
            "JR NZ,n", "LD HL,nn", "LDI (HL),A", "INC HL", "INC H", "DEC H", "LD H,n", "DAA",
            "JR Z,n", "ADD HL,HL", "LDI A,(HL)", "DEC HL", "INC L", "DEC L", "LD L,n", "CPL",
            "JR NC,n", "LD SP,nn", "LDD (HL),A", "INC SP", "INC (HL)", "DEC (HL)", "LD (HL),n",
            "SCF", "JR C,n", "ADD HL,SP", "LDD A,(HL)", "DEC SP", "INC A", "DEC A", "LD A,n",
            "CCF", "LD B,B", "LD B,C", "LD B,D", "LD B,E", "LD B,H", "LD B,L", "LD B,(HL)",
            "LD B,A", "LD C,B", "LD C,C", "LD C,D", "LD C,E", "LD C,H", "LD C,L", "LD C,(HL)",
            "LD C,A", "LD D,B", "LD D,C", "LD D,D", "LD D,E", "LD D,H", "LD D,L", "LD D,(HL)",
            "LD D,A", "LD E,B", "LD E,C", "LD E,D", "LD E,E", "LD E,H", "LD E,L", "LD E,(HL)",
            "LD E,A", "LD H,B", "LD H,C", "LD H,D", "LD H,E", "LD H,H", "LD H,L", "LD H,(HL)",
            "LD H,A", "LD L,B", "LD L,C", "LD L,D", "LD L,E", "LD L,H", "LD L,L", "LD L,(HL)",
            "LD L,A", "LD (HL),B", "LD (HL),C", "LD (HL),D", "LD (HL),E", "LD (HL),H", "LD (HL),L",
            "HALT", "LD (HL),A", "LD A,B", "LD A,C", "LD A,D", "LD A,E", "LD A,H", "LD A,L",
            "LD A,(HL)", "LD A,A", "ADD A,B", "ADD A,C", "ADD A,D", "ADD A,E", "ADD A,H",
            "ADD A,L", "ADD A,(HL)", "ADD A,A", "ADC A,B", "ADC A,C", "ADC A,D", "ADC A,E",
            "ADC A,H", "ADC A,L", "ADC A,(HL)", "ADC A,A", "SUB A,B", "SUB A,C", "SUB A,D",
            "SUB A,E", "SUB A,H", "SUB A,L", "SUB A,(HL)", "SUB A,A", "SBC A,B", "SBC A,C",
            "SBC A,D", "SBC A,E", "SBC A,H", "SBC A,L", "SBC A,(HL)", "SBC A,A", "AND B", "AND C",
            "AND D", "AND E", "AND H", "AND L", "AND (HL)", "AND A", "XOR B", "XOR C", "XOR D",
            "XOR E", "XOR H", "XOR L", "XOR (HL)", "XOR A", "OR B", "OR C", "OR D", "OR E", "OR H",
            "OR L", "OR (HL)", "OR A", "CP B", "CP C", "CP D", "CP E", "CP H", "CP L", "CP (HL)",
            "CP A", "RET NZ", "POP BC", "JP NZ,nn", "JP nn", "CALL NZ,nn", "PUSH BC", "ADD A,n",
            "RST 0", "RET Z", "RET", "JP Z,nn", "Ext ops", "CALL Z,nn", "CALL nn", "ADC A,n",
            "RST 8", "RET NC", "POP DE", "JP NC,nn", "XX", "CALL NC,nn", "PUSH DE", "SUB A,n",
            "RST 10", "RET C", "RETI", "JP C,nn", "XX", "CALL C,nn", "XX", "SBC A,n", "RST 18",
            "LDH (n),A", "POP HL", "LDH (C),A", "XX", "XX", "PUSH HL", "AND n", "RST 20",
            "ADD SP,d", "JP (HL)", "LD (nn),A", "XX", "XX", "XX", "XOR n", "RST 28", "LDH A,(n)",
            "POP AF", "XX", "DI", "XX", "PUSH AF", "OR n", "RST 30", "LDHL SP,d", "LD SP,HL",
            "LD A,(nn)", "EI", "XX", "XX", "CP n", "RST 38" };

   public void printStats() {
      try{
         writer = new PrintWriter("../estatisticas.str", "UTF-8");
         
         for (int i = 0; i < 256; i++) {
            if (map[i] > 0000) {
               writer.println(i + "\t" + map[i] + "\t" + s[i]);
            }
         }
         
         writer.println("\n");
         for (int i : instructions) {
            if (map[i] > 0000) {
               writer.println(i);
            }
         }
         
         writer.close();
         
      } catch(FileNotFoundException e){
         System.out.println("Stats: File not found " + e.getMessage());
      } catch (UnsupportedEncodingException e) {
         System.out.println("Stats: unsuported operation " + e.getMessage());
      }
      
      
   }

   public void addExecution(int b1) {
      map[b1]++;
      instructions.add(b1);
   }
}
