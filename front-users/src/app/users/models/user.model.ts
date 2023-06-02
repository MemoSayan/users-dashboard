export interface Users {
    id:       number;
    phone:    string;
    name:     string;
    lastName: string;
    email:    string;
    jobTitle: string;
    token:    string;
}

// Converts JSON strings to/from your types
export class Convert {
    public static toUsers(json: string): Users {
        return JSON.parse(json);
    }

    public static usersToJson(value: Users): string {
        return JSON.stringify(value);
    }
}
