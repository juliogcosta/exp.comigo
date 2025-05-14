DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM information_schema.schemata WHERE schema_name = 'usuario') THEN
        CREATE SCHEMA usuario;
    END IF;
END $$;