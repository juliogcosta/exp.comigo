DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM information_schema.schemata WHERE schema_name = 'atendimento') THEN
        CREATE SCHEMA atendimento;
    END IF;
END $$;