public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();

        byte[] rawDataDevice = {
                0b00000111, 0b00000000, // Example BITSET16 flags for DEVICE.CONTROL.Stat
                0x12, 0x34, 0x56, 0x78, // Example BCD32 Train ID (Binary coded decimal)
                'D', 'R', 'I', 'V', 'E', 'R', '0', '1', 0, 0, 0, 0, 0, 0, 0, 0 // Example STRING16 Driver ID
        };

        byte[] rawDataControl = {
                0b00000001, 0b00000010, 0b00000011, 0b00000100, // Example BITSET32 flags
                (byte)0x64, // UINT8 control value (100%)
                (byte)0x00, (byte)0x32, // UINT16 velocity (50 cm/s)
                (byte)0xC8, (byte)0x00, // UINT16 train length (200 m)
                (byte) 0x01, (byte) 0x00, (byte) 0x00, (byte) 0x00, // UINT32 LRBG (1)
                (byte) 0xE8, (byte) 0x03, (byte) 0x00, (byte) 0x00, // INT32 Position (1000 cm or 10 m)
                (byte) 0x02, // UINT8 Control Status (2: CONTROL engaged)
                (byte) 0x02, (byte) 0x00, (byte) 0x00, (byte) 0x00, // UINT32 Mission Start TP (2)
                (byte) 0x01, (byte) 0x00, (byte) 0x00, (byte) 0x00, // UINT32 Mission Start Position (1)
                (byte) 0x01, (byte) 0x00, // UINT16 Mission Start Date (1)
                (byte) 0x10, (byte) 0x00, (byte) 0x00, (byte) 0x00, // UINT32 Mission Start Time (16)
                (byte) 0x03, (byte) 0x00, (byte) 0x00, (byte) 0x00, // UINT32 Mission End TP (3)
                (byte) 0x02, (byte) 0x00, (byte) 0x00, (byte) 0x00, // UINT32 Mission End Position (2)
                (byte) 0x02, (byte) 0x00, // UINT16 Mission End Date (2)
                (byte) 0x20, (byte) 0x00, (byte) 0x00, (byte) 0x00, // UINT32 Mission End Time (32)
                (byte) 0x01, (byte) 0x00, (byte) 0x00, (byte) 0x00, // UINT32 Position of Train Front End within JP (1)
                (byte) 0x0A, (byte) 0x00 // UINT16 Dwell Time (10 seconds)
        };

        RecordType recordDevice = parser.decodeDeviceControlStat(rawDataDevice);
        System.out.println("Decoded DEVICE.CONTROL.Stat: " + recordDevice.toStringDeviceControlStat());

        RecordType recordControl = parser.decodeControlDeviceStat(rawDataControl);
        System.out.println("Decoded CONTROL.DEVICE.Stat: " + recordControl.toStringControlDeviceStat());

    }
}
