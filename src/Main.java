public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();

        byte[] rawDataDevice = {
                0b00000111, 0b00000000, // Example BITSET16 flags for DEVICE.CONTROL.Stat
                0x12, 0x34, 0x56, 0x78, // Example BCD32 Train ID
                'D', 'R', 'I', 'V', 'E', 'R', '0', '1', 0, 0, 0, 0, 0, 0, 0, 0 // Example STRING16 Driver ID
        };

        byte[] rawDataControl = {
                0b00000001, 0b00000010, 0b00000011, 0b00000100, // Example BITSET32 flags
                (byte)0x64, // UINT8 control value (100%)
                (byte)0x00, (byte)0x32, // UINT16 velocity (50 cm/s)
                (byte)0x01, (byte)0xF4, // UINT16 train length (500 m)
                (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x01, // UINT32 LRBG
                (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, // INT32 position (-1 for example)
                (byte)0x03, // UINT8 control status (2: CONTROL engaged)
                (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x02, // UINT32 mission start TP
                (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x01, // UINT32 mission start position
                (byte)0x00, (byte)0x01, // UINT16 mission start date
                (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x10, // UINT32 mission start time
                (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x03, // UINT32 mission end TP
                (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x02, // UINT32 mission end position
                (byte)0x00, (byte)0x02, // UINT16 mission end date
                (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x20, // UINT32 mission end time
                (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x01, // UINT32 jppos
                (byte)0x00, (byte)0x0A // UINT16 tdwell (10 s)
        };

        RecordType recordDevice = parser.decodeDeviceControlStat(rawDataDevice);
        System.out.println("Decoded DEVICE.CONTROL.Stat: " + recordDevice);

        RecordType recordControl = parser.decodeControlDeviceStat(rawDataControl);
        System.out.println("Decoded CONTROL.DEVICE.Stat: " + recordControl);
    }
}
