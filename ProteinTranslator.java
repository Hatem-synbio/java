import java.util.HashMap;
import java.util.Map;

public class ProteinTranslator {

    /**
     * Translates a DNA nucleotide sequence into an amino acid sequence.
     *
     * @param nucleotideSequence The DNA sequence to be translated.
     * @return The resulting amino acid sequence as a String.
     */
    public static String translateToAminoAcids(String nucleotideSequence) {
        Map<String, String> codonTable = new HashMap<>();
        codonTable.put("TTT", "F"); codonTable.put("TTC", "F"); // Phenylalanine
        codonTable.put("TTA", "L"); codonTable.put("TTG", "L"); // Leucine
        codonTable.put("CTT", "L"); codonTable.put("CTC", "L");
        codonTable.put("CTA", "L"); codonTable.put("CTG", "L");
        codonTable.put("ATT", "I"); codonTable.put("ATC", "I"); // Isoleucine
        codonTable.put("ATA", "I");
        codonTable.put("ATG", "M");                              // Methionine (Start)
        codonTable.put("GTT", "V"); codonTable.put("GTC", "V"); // Valine
        codonTable.put("GTA", "V"); codonTable.put("GTG", "V");
        codonTable.put("TCT", "S"); codonTable.put("TCC", "S"); // Serine
        codonTable.put("TCA", "S"); codonTable.put("TCG", "S");
        codonTable.put("CCT", "P"); codonTable.put("CCC", "P"); // Proline
        codonTable.put("CCA", "P"); codonTable.put("CCG", "P");
        codonTable.put("ACT", "T"); codonTable.put("ACC", "T"); // Threonine
        codonTable.put("ACA", "T"); codonTable.put("ACG", "T");
        codonTable.put("GCT", "A"); codonTable.put("GCC", "A"); // Alanine
        codonTable.put("GCA", "A"); codonTable.put("GCG", "A");
        codonTable.put("TAT", "Y"); codonTable.put("TAC", "Y"); // Tyrosine
        codonTable.put("TAA", "*"); codonTable.put("TAG", "*"); // Stop
        codonTable.put("CAT", "H"); codonTable.put("CAC", "H"); // Histidine
        codonTable.put("CAA", "Q"); codonTable.put("CAG", "Q"); // Glutamine
        codonTable.put("AAT", "N"); codonTable.put("AAC", "N"); // Asparagine
        codonTable.put("AAA", "K"); codonTable.put("AAG", "K"); // Lysine
        codonTable.put("GAT", "D"); codonTable.put("GAC", "D"); // Aspartic acid
        codonTable.put("GAA", "E"); codonTable.put("GAG", "E"); // Glutamic acid
        codonTable.put("TGT", "C"); codonTable.put("TGC", "C"); // Cysteine
        codonTable.put("TGA", "*");                             // Stop
        codonTable.put("TGG", "W");                              // Tryptophan
        codonTable.put("CGT", "R"); codonTable.put("CGC", "R"); // Arginine
        codonTable.put("CGA", "R"); codonTable.put("CGG", "R");
        codonTable.put("AGT", "S"); codonTable.put("AGC", "S"); // Serine
        codonTable.put("AGA", "R"); codonTable.put("AGG", "R"); // Arginine
        codonTable.put("GGT", "G"); codonTable.put("GGC", "G"); // Glycine
        codonTable.put("GGA", "G"); codonTable.put("GGG", "G");

        nucleotideSequence = nucleotideSequence.toUpperCase();

        // Print the entire nucleotide sequence before translation
        System.out.println("Nucleotide Sequence: " + nucleotideSequence);

        StringBuilder aminoAcidSequence = new StringBuilder();

        for (int i = 0; i <= nucleotideSequence.length() - 3; i += 3) {
            String codon = nucleotideSequence.substring(i, i + 3);
            String aminoAcid = codonTable.getOrDefault(codon, "?");
            aminoAcidSequence.append(aminoAcid);

            if ("*".equals(aminoAcid)) {
                break;
            }
        }

        return aminoAcidSequence.toString();
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a nucleotide sequence as an argument.");
            return;
        }

        String nucleotideSequence = args[0];
        String aminoAcidSequence = translateToAminoAcids(nucleotideSequence);
        System.out.println("Amino Acid Sequence: " + aminoAcidSequence);
    }
}
