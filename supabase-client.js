const SUPABASE_URL = "https://qpdgstldpatahxfzexsl.supabase.co";
const SUPABASE_PUBLISHABLE_KEY = "sb_publishable_C36S0d5zq1lOEZgqZdWuSQ_I1qEXB_W";

const supabaseClient = window.supabase.createClient(
    SUPABASE_URL,
    SUPABASE_PUBLISHABLE_KEY
);

console.log("Client Supabase chargé :", supabaseClient);